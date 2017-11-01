package com.panda.org.angrypandalonglink;

import android.app.Application;

import com.tencent.mars.comm.PlatformComm;


/**
 * Created by rd0348 on 2017/10/30 0030.
 */

public class AngryPandaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*
        * 初始化mars
        * */
        PlatformComm.init(getApplicationContext(),null);

    }
}
