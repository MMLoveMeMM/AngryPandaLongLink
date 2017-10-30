package com.panda.org.marsserver.mina.filter;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class CharsetCodecFactory implements ProtocolCodecFactory {

	private Charset charset=null;
	public CharsetCodecFactory(Charset charset){
		this.charset=charset;
	}
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return new CharsetDecoder(charset);
	}

	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return new CharsetEncoder(charset);
	}

}
