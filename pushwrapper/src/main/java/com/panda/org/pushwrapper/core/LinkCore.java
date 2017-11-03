package com.panda.org.pushwrapper.core;

import com.panda.org.pushwrapper.aidl.LongLinkConfItem;
import com.panda.org.pushwrapper.aidl.MsgItem;

/**
 * Created by rd0348 on 2017/11/2 0002.
 */

public class LinkCore {

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
