// IPushMsgCallbackListener.aidl
package com.panda.org.pushwrapper.aidl;
import java.lang.String;
// Declare any non-default types here with import statements

interface IPushMsgCallbackListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    //void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
    //        double aDouble, String aString);

    void PushMsgItemProc(int msg,String pushmsg,int lparam);
}
