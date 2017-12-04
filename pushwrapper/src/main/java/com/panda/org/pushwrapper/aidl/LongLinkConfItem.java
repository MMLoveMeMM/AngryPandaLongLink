package com.panda.org.pushwrapper.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rd0348 on 2017/10/31 0031.
 * 需要配置的参数 :
 * <1> : 日志是否打印;
 * <2> : 是否鉴权,如果需要鉴权就需要提供鉴权信息;
 * <3> : 工作路径;
 * <4> : 心跳时间间隔;
 */

public class LongLinkConfItem implements Parcelable {

    private int enablexlog;
    private int isAuth;
    private String authInfo;// json格式字符窜或者protobuf 序列化后的字符串
    private String work_dir;
    private int interval;
    private int enableKeepalive; // 使能一个udp链接,辅助支持链接状态
    private String longlinkhost; // eg : 192.168.11.19:6000
    private String shortlinkhost;

    protected LongLinkConfItem(Parcel in) {
        enablexlog = in.readInt();
        isAuth = in.readInt();
        authInfo = in.readString();
        work_dir = in.readString();
        interval = in.readInt();
        enableKeepalive = in.readInt();
    }

    public static final Creator<LongLinkConfItem> CREATOR = new Creator<LongLinkConfItem>() {
        @Override
        public LongLinkConfItem createFromParcel(Parcel in) {
            return new LongLinkConfItem(in);
        }

        @Override
        public LongLinkConfItem[] newArray(int size) {
            return new LongLinkConfItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel source){
        enablexlog = source.readInt();
        isAuth = source.readInt();
        authInfo = source.readString();
        work_dir = source.readString();
        interval = source.readInt();
        enableKeepalive = source.readInt();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(enablexlog);
        dest.writeInt(isAuth);
        dest.writeString(authInfo);
        dest.writeString(work_dir);
        dest.writeInt(interval);
        dest.writeInt(enableKeepalive);
    }

    public int getEnablexlog() {
        return enablexlog;
    }

    public void setEnablexlog(int enablexlog) {
        this.enablexlog = enablexlog;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getWork_dir() {
        return work_dir;
    }

    public void setWork_dir(String work_dir) {
        this.work_dir = work_dir;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getEnableKeepalive() {
        return enableKeepalive;
    }

    public void setEnableKeepalive(int enableKeepalive) {
        this.enableKeepalive = enableKeepalive;
    }

    public String getLonglinkhost() {
        return longlinkhost;
    }

    public void setLonglinkhost(String longlinkhost) {
        this.longlinkhost = longlinkhost;
    }

    public String getShortlinkhost() {
        return shortlinkhost;
    }

    public void setShortlinkhost(String shortlinkhost) {
        this.shortlinkhost = shortlinkhost;
    }

    public static Creator<LongLinkConfItem> getCREATOR() {
        return CREATOR;
    }
}
