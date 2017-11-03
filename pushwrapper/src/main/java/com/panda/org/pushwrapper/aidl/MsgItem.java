package com.panda.org.pushwrapper.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rd0348 on 2017/10/31 0031.
 */

public class MsgItem implements Parcelable {

    private int head_length;
    private int client_version;
    private int cmdid;
    private int seq;
    private int body_length;
    private String Body;


    protected MsgItem(Parcel in) {
        head_length = in.readInt();
        client_version = in.readInt();
        cmdid = in.readInt();
        seq = in.readInt();
        body_length = in.readInt();
        Body = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(head_length);
        dest.writeInt(client_version);
        dest.writeInt(cmdid);
        dest.writeInt(seq);
        dest.writeInt(body_length);
        dest.writeString(Body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MsgItem> CREATOR = new Creator<MsgItem>() {
        @Override
        public MsgItem createFromParcel(Parcel in) {
            return new MsgItem(in);
        }

        @Override
        public MsgItem[] newArray(int size) {
            return new MsgItem[size];
        }
    };

    public int getHead_length() {
        return head_length;
    }

    public void setHead_length(int head_length) {
        this.head_length = head_length;
    }

    public int getClient_version() {
        return client_version;
    }

    public void setClient_version(int client_version) {
        this.client_version = client_version;
    }

    public int getCmdid() {
        return cmdid;
    }

    public void setCmdid(int cmdid) {
        this.cmdid = cmdid;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getBody_length() {
        return body_length;
    }

    public void setBody_length(int body_length) {
        this.body_length = body_length;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public static Creator<MsgItem> getCREATOR() {
        return CREATOR;
    }
}
