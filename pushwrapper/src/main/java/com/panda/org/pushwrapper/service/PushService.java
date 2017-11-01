package com.panda.org.pushwrapper.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.panda.org.pushwrapper.aidl.IPushMsgCallbackListener;
import com.panda.org.pushwrapper.aidl.ISerivceInterface;
import com.panda.org.pushwrapper.aidl.LongLinkConfItem;

/**
 * Created by rd0348 on 2017/10/31 0031.
 */

public class PushService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private ISerivceInterface stub=new ISerivceInterface.Stub(){

        @Override
        public void confLongLinkInfo(LongLinkConfItem config) throws RemoteException {

        }

        @Override
        public void registerCallBackFilter(IPushMsgCallbackListener lis) throws RemoteException {

        }

        @Override
        public void unregisterCallBackFilter() throws RemoteException {

        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
