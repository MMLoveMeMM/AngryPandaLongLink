/**
 * 
 */
package com.panda.org.pushwrapper.proxy;

/**
 * @author rd0348
 *
 */
public interface ILongLinkSysListener<T> {
	/*
	 * T : 目前是String型
	 * */
	public boolean OnSysMsgProc(int msg, T wparam, int lParam);

}
