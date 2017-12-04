package com.panda.org.pushwrapper.proxy;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

import com.panda.org.pushwrapper.aidl.IPushMsgCallbackListener;
import com.panda.org.pushwrapper.aidl.ISerivceInterface;
import com.panda.org.pushwrapper.aidl.LongLinkConfItem;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by rd0348 on 2017/12/2 0002.
 */

public class PushServiceProxy implements ServiceConnection {

    private final static String TAG = "PushServiceProxy";

    private final static String SERVICE_DEFUALT_CLASSNAME = "com.panda.org.pushwrapper.service.PushService";

    private ISerivceInterface service;
    private boolean mBindStatus = false;
    private static String gPackageName;
    private static String gClassName;
    public static PushServiceProxy instance;
    private static Context gContext;

    private HashSet<ILongLinkSysListener<String>> mIViewProxyListeners = new HashSet<ILongLinkSysListener<String>>();

    /*
	 * APP 初始化这个实例
	 * */
    public static void init(Context context, Looper looper, String packageName) {

        if (instance != null) {
            // TODO: Already initialized
            return;
        }

        gContext = context.getApplicationContext();
        gPackageName = (packageName == null ? context.getPackageName() : packageName);
        gClassName = SERVICE_DEFUALT_CLASSNAME;
        instance = new PushServiceProxy();

    }

    public void RegisterViewMsgProc(ILongLinkSysListener<String> lis)
    {
        mIViewProxyListeners.add(lis);
    }
    /*
	 * 消息回调 :
	 * 提供了两种回调方式
	 * */
    private IPushMsgCallbackListener.Stub mPushMsgProc = new IPushMsgCallbackListener.Stub() {

        @Override
        public void PushMsgItemProc(int msg, String pushmsg, int lparam) throws RemoteException {
            // 回调的消息处
            Log.i(TAG,"mPushMsgProc successfully ! ****************");
            Log.i("bql",TAG+"mPushMsgProc body : "+pushmsg);
            // 这个地方进一步再回调到需要数据的UI界面
            Iterator<ILongLinkSysListener<String>> it = mIViewProxyListeners.iterator();
            ILongLinkSysListener<String> listener;
            while (it.hasNext()) {
                listener = it.next();
                listener.OnSysMsgProc(msg, pushmsg, lparam);//凡是註冊過的都回調
            }
        }
    };

    /*
	 * 注册Service消息回调处
	 * */
    public void registerPushMessageFilter() {
        if (service != null && mPushMsgProc != null) {
            try {
                service.registerCallBackFilter(mPushMsgProc);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void unregisterPushMessageFilter() {
        if (service != null) {
            try {
                service.unregisterCallBackFilter();
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
	 * 传递初始化长连接
	 * */
    public void confUserLoginDataInfo(LongLinkConfItem data) {
        if (service != null) {
            try {
                service.confLongLinkInfo(data);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void startBindService() {

        if (service == null) {
            Log.i(TAG, "try to bind remote mars service, packageName:"+ gPackageName +" , className: "+gClassName);
            Intent i = new Intent().setClassName(gPackageName, gClassName);
            gContext.startService(i);
            if (!gContext.bindService(i, instance, Service.BIND_AUTO_CREATE)) {
                Log.e(TAG, "remote mars service bind failed");
            }

            return;
        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder srv) {
        service = ISerivceInterface.Stub.asInterface(srv);
        mBindStatus = true;

        if (service != null) {
            Log.i(TAG,"onServiceConnected successfully !");
            instance.registerPushMessageFilter();// 绑定成功以后就注册回调时间
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mBindStatus = false;
    }
}
