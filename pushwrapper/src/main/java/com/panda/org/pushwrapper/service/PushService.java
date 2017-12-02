package com.panda.org.pushwrapper.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.panda.org.pushwrapper.aidl.IPushMsgCallbackListener;
import com.panda.org.pushwrapper.aidl.ISerivceInterface;
import com.panda.org.pushwrapper.aidl.LongLinkConfItem;
import com.panda.org.pushwrapper.aidl.MsgItem;
import com.panda.org.pushwrapper.core.LinkCore;
import com.panda.org.pushwrapper.proxy.IPushMsgListener;

/**
 * Created by rd0348 on 2017/10/31 0031.
 */

public class PushService extends Service implements IPushMsgListener {

    private IPushMsgCallbackListener mListener;

    private LinkCore mLinkCore;

    private boolean mBindStatus = false;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mBindStatus = true;
        return stub;
    }

    private ISerivceInterface.Stub stub=new ISerivceInterface.Stub(){

        @Override
        public void confLongLinkInfo(LongLinkConfItem config) throws RemoteException {

            if(mLinkCore!=null)
            {
               /*
            * 配置长连接
            * 并且启动长连接
            * */
                mLinkCore.LinkCoreInit(config);
            }

        }

        @Override
        public void registerCallBackFilter(IPushMsgCallbackListener lis) throws RemoteException {

            if(mLinkCore!=null)
            {
                mListener=lis;
            }
        }

        @Override
        public void unregisterCallBackFilter() throws RemoteException {
            if(mListener!=null)
            {
                mListener=null;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        mLinkCore = new LinkCore();
        mLinkCore.initMarsCore(this);

    }

    @Override
    public void PushMsgSysProc(int msg, Object obj, int lparam) throws RemoteException {

        MsgItem msginfo=(MsgItem)obj;
        Log.i("bql","push service PushMsgSysProc body : "+msginfo.getBody());
        if(mBindStatus) {
            mListener.PushMsgItemProc(msg, msginfo.getBody(), msginfo.getCmdid()/*lparam*/);
        }else {
				/*
				 * 离线情况下不需要保存被踢出等这种系统消息
				 * */
        }

    }
}
