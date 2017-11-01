// ISerivceInterface.aidl
package com.panda.org.pushwrapper.aidl;
import com.panda.org.pushwrapper.aidl.LongLinkConfItem;
import com.panda.org.pushwrapper.aidl.IPushMsgCallbackListener;
// Declare any non-default types here with import statements

interface ISerivceInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void confLongLinkInfo(inout LongLinkConfItem config);

    void registerCallBackFilter(IPushMsgCallbackListener lis);

    void unregisterCallBackFilter();
}
