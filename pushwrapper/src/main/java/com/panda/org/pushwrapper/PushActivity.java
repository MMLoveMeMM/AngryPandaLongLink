package com.panda.org.pushwrapper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.panda.org.pushwrapper.R;
import com.panda.org.pushwrapper.aidl.LongLinkConfItem;
import com.panda.org.pushwrapper.proxy.ILongLinkSysListener;
import com.panda.org.pushwrapper.proxy.PushServiceProxy;

import java.io.File;

public class PushActivity extends Activity implements ILongLinkSysListener {

    private Button mStartLK;
    private LongLinkConfItem mLongLinkConfItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        PushServiceProxy.init(getApplicationContext(),null,"com.panda.org.angrypandalonglink");//初始化代理
        PushServiceProxy.instance.startBindService();
        PushServiceProxy.instance.RegisterViewMsgProc(this);//注册消息回调

        mStartLK=(Button)findViewById(R.id.startlk);
        mStartLK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLongLinkConfItem.setIsAuth(0);//这里测试就不鉴权
                mLongLinkConfItem.setEnableKeepalive(0);
                mLongLinkConfItem.setEnablexlog(1);//打印日志
                mLongLinkConfItem.setInterval(30*1000);//心跳时间间隔
                mLongLinkConfItem.setLonglinkhost("http://192.168.1.187:60000");//连接服务器的主机地址和端口
                mLongLinkConfItem.setWork_dir(initStorageFolder("log"));//工作路径和日志路径
                PushServiceProxy.instance.confUserLoginDataInfo(mLongLinkConfItem);
            }
        });

    }

    @Override
    public boolean OnSysMsgProc(int msg, Object wparam, int lParam) {
        Toast.makeText(PushActivity.this,"msg : "+(String)wparam,Toast.LENGTH_SHORT).show();
        return true;
    }

    private String initStorageFolder(String folder){
        File logDir;
        if(isExternalStorageWritable()){
            logDir = new File(PushActivity.this.getExternalFilesDir(null),folder);
        } else {
            logDir = new File(PushActivity.this.getFilesDir(),folder);
        }
        if (!logDir.exists()){
            logDir.mkdir();
        }

        if (!logDir.exists()) {
            logDir = new File(PushActivity.this.getFilesDir(),folder);
            if (!logDir.exists()){
                if(!logDir.mkdir()){
                    return null;
                }
            }
        }

        return logDir.getAbsolutePath();
    }
    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

}
