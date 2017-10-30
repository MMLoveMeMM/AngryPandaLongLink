package com.panda.org.marsserver.mina.pkt;

import java.io.Serializable;

/*
* mars 默认的数据结构
struct __STNetMsgXpHeader {
    uint32_t    head_length;
    uint32_t    client_version;
    uint32_t    cmdid;
    uint32_t    seq;
    uint32_t	body_length;
};
* */

public abstract class Packet implements Serializable{

	protected int head_length;
	protected int client_version;
	protected int cmdid;
	protected int seq;
	protected int body_length;
	protected String Body;

	public int getHead_length() {
		return head_length;
	}

	public void setHead_length(int head_length) {
		this.head_length = head_length;
	}

	public int getClient_version() {
		return client_version;
	}

	public void setClient_version(int client_version) {
		this.client_version = client_version;
	}

	public int getCmdid() {
		return cmdid;
	}

	public void setCmdid(int cmdid) {
		this.cmdid = cmdid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBody_length() {
		return body_length;
	}

	public void setBody_length(int body_length) {
		this.body_length = body_length;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}
}
