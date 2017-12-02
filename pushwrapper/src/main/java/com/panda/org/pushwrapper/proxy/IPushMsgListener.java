package com.panda.org.pushwrapper.proxy;

import android.os.RemoteException;

public interface IPushMsgListener<T> {
	
	public void PushMsgSysProc(int msg, T obj, int lparam) throws RemoteException;
	
}
