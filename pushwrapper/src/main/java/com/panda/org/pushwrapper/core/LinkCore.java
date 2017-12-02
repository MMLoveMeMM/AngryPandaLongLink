package com.panda.org.pushwrapper.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.panda.org.pushwrapper.aidl.LongLinkConfItem;
import com.panda.org.pushwrapper.aidl.MsgItem;
import com.panda.org.pushwrapper.proxy.IPushMsgListener;
import android.os.Process;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rd0348 on 2017/11/2 0002.
 */

public class LinkCore {

    private final static String TAG = "LinkCore";

    static LinkCore instance;

    static{
        System.loadLibrary("linkcore");
    }

    public static synchronized LinkCore initMarsCore(IPushMsgListener listener) {

        if (null == instance) {
            instance = new LinkCore();
            instance.addPushMsgListener(listener);
            Log.d(TAG,"initCore .............. ");
        }

        return instance;

    }

    public LinkCore() {

        HandlerThread mHandlerThread = new HandlerThread("pushmsg_thread",
                Process.THREAD_PRIORITY_BACKGROUND) {

            @Override
            protected void onLooperPrepared() {
                mSysProcHandler=new SysProcHandler(getLooper());
            }
        };
        mHandlerThread.start();

    }
    private static Handler getResponseHandle() {
        if (null != instance) {
            if(instance.mSysProcHandler == null){
                //Log.w(TAG,"middleware response handler thread not start yet...");
            }
            return instance.mSysProcHandler;
        }
        return null;
    }
    /**
     * 这里只需要注册一个就好了
     */
    private IPushMsgListener<Object> mIPushMsgListener;
    public void addPushMsgListener(IPushMsgListener listener) {
        mIPushMsgListener=listener;
    }

    /*
     * 当然如果需要提供多个实现注册,可以参照如下
     * */
    private Set<IPushMsgListener> mMulIPushMsgListener = new HashSet<IPushMsgListener>();

    private static final int MSG_SYS = 2;
    // 供底层调用
    private static void cnSysMsgProcInner(int msg, Object wparam, int lparam) {
        // jni 回调
        Handler mainHandler = getResponseHandle();

        if (null != mainHandler) {
            Message message = Message.obtain(mainHandler, MSG_SYS, msg, lparam, wparam);
            mainHandler.sendMessage(message);
        }else{
            //Log.e(TAG,"cnSysMsgProcInner mainHandler == null");
        }
    }

    private SysProcHandler mSysProcHandler;
    private class SysProcHandler extends Handler {

        public SysProcHandler(Looper looper) {
            super(looper);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            // 推到PushService
            try {
                mIPushMsgListener.PushMsgSysProc(msg.arg1, msg.obj, msg.arg2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
    }

    /*
    * 配置参数并且初始化
    * */
    public native int LinkCoreInit(LongLinkConfItem items);

    /*
    * 启动连接
    * */
    public native int LinkCoreStart();

    /*
    * 重置连接
    * 短连接不需要重置
    * */
    public native int ResetLongLink();

    /*
    * 获取当前连接状态
    * 短连接不需要判断
    * */
    public native int IsLongLinkConnect();

    /*
    * 前后台切换
    * */
    public native int OnForeground(int fore);

    /*
    * 主动发送一个消息或者反馈ACK给服务器
    * */
    public native int StartPushMsg(MsgItem item);

    /*
    * 这个不是非常必要的
    * */
    public native int DestroyLink();
}
