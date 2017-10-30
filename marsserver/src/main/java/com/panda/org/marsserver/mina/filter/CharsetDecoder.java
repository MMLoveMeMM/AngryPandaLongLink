package com.panda.org.marsserver.mina.filter;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import com.apkfuns.logutils.LogUtils;
import com.panda.org.marsserver.mina.pkt.ReqPacket;

public class CharsetDecoder extends ProtocolDecoderAdapter {

	private Charset charset=null;
	
	public CharsetDecoder(Charset charset){
		this.charset=charset;
	}
	
	public void decode(IoSession arg0, IoBuffer message, ProtocolDecoderOutput arg2)
			throws Exception {
		// TODO Auto-generated method stub
		
		LogUtils.i("DECODE","message : "+message);
		
		java.nio.charset.CharsetDecoder cd = charset.newDecoder();
		int head_length=message.getInt();
		int client_version = message.getInt();
		int cmdid = message.getShort();
		int seq=message.getInt();
		int body_length=message.getInt();

		String body=message.getString(cd);

		LogUtils.i("DECODE","body : "+body);
		
		ReqPacket paEntity = new ReqPacket();
		paEntity.setHead_length(head_length);
		paEntity.setClient_version(client_version);
		paEntity.setCmdid(cmdid);
		paEntity.setSeq(seq);
		paEntity.setBody_length(body_length);
		paEntity.setBody(body);
		
		arg2.write(paEntity);

	}

}
