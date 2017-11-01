package com.panda.org.pushwrapper.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rd0348 on 2017/10/31 0031.
 */

public class MsgItem implements Parcelable {
    private int cmdid;
    private String body;


    protected MsgItem(Parcel in) {
        cmdid = in.readInt();
        body = in.readString();
    }
    public void readFromParcel(Parcel source){
        cmdid=source.readInt();
        body=source.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cmdid);
        dest.writeString(body);
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
}
