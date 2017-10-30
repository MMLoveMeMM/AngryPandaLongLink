package com.panda.org.marsserver.mina.filter;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.apkfuns.logutils.LogUtils;
import com.panda.org.marsserver.mina.pkt.ReqPacket;


public class CharsetEncoder extends ProtocolEncoderAdapter {

	private Charset charset=null;
	
	public CharsetEncoder(Charset charset){
		this.charset=charset;
	}
	@Override
	public void dispose(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public void encode(IoSession arg0, Object message, ProtocolEncoderOutput out)
			throws Exception {
		// TODO Auto-generated method stub
		java.nio.charset.CharsetEncoder ce = charset.newEncoder();
		ReqPacket paEntity = (ReqPacket) message;
		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
		buffer.putInt(paEntity.getHead_length());
		buffer.putInt(paEntity.getClient_version());
		buffer.putInt(paEntity.getCmdid());
		buffer.putInt(paEntity.getSeq());
		buffer.putInt(paEntity.getBody_length());
		buffer.putString(paEntity.getBody(), ce);
		
		buffer.flip();
		out.write(buffer);
		LogUtils.i("DECODE","buffer : "+buffer);
	}

}
