package com.panda.org.marsserver.mina;

import com.panda.org.marsserver.mina.filter.CharsetCodecFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MarsMinaServer{

	private static final int PORT = 9527;
	
	private SocketAcceptor acceptor ;
	private ServerProtocolHandler mPIOHandler;

	public MarsMinaServer(){
		
		if(acceptor!=null){
			StopServer();
		}
		
		acceptor = new NioSocketAcceptor();
		mPIOHandler=new ServerProtocolHandler();
		
	}
	
	private class ServerTask implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			startServer();
		}
		
	}
	
	public void StartServer(){
		
		new Thread(new ServerTask()).start();
		
	}
	
	private class StopServerTask implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			StopServer();
		}
		
	}
	
	public void StopServer(){
		
		if(acceptor!=null){
			acceptor.unbind();
			acceptor=null;
		}
		
	}
	
	public void startServer(){
		
		acceptor = new NioSocketAcceptor();
		acceptor.setReuseAddress(true);
		// 添加编码过滤器 处理乱码、编码问题
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory(Charset.forName( "UTF-8" ))));

		// Bind
		mPIOHandler=new ServerProtocolHandler();
		acceptor.setHandler(mPIOHandler);
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
		
		try {
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//LOG.info("Listening on port " + PORT);
		System.out.println("Listening on port " + PORT);
		//LOG.info("Server started!");

		for (;;) {
			//LOG.info("R: " + acceptor.getStatistics().getReadBytesThroughput() + ", W: " + acceptor.getStatistics().getWrittenBytesThroughput());
			if(acceptor==null){
				return;
			}
			System.out.println("R: " + acceptor.getStatistics().getReadBytesThroughput() + ", W: " + acceptor.getStatistics().getWrittenBytesThroughput());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
