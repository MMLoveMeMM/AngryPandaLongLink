package com.panda.org.marsserver.mina;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.panda.org.marsserver.mina.pkt.ReqPacket;

public class ServerProtocolHandler extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		//mNetListener.updateServerSession(Utils.SERVER_SESSION_STATUS.SERVER_SESSION_EXCEPTION);
		
		//super.exceptionCaught(session, cause);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		//mNetListener.updateServerSession(Utils.SERVER_SESSION_STATUS.SERVER_SESSION_CLOSE);
		super.inputClosed(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(session, message);
		
		Log.i("DECODE","messageReceived cmd ...");
		
		ReqPacket req=(ReqPacket)message;

		//CommandProcess.getInstance().process((ReqPacket)message);

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
		ReqPacket req=(ReqPacket)message;
		Log.i("DECODE","messageSent send message : ");
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		LogUtils.i("server create !");
		//这里是保存了多台操作不同端口的服务器session
		int port = ((InetSocketAddress)session.getLocalAddress()).getPort();
		Log.i("sport","ppoprt : "+port);
		
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		LogUtils.i("server open !");
	}

}
