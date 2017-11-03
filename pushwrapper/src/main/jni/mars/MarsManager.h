#ifndef __H_MARS_MANAGER_H__
#define __H_MARS_MANAGER_H__
#include<stdlib.h>
#include<stdio.h>
#include<string>
#include <queue>
#include <map>
#include <string>
#include<vector>
#include "comm/thread/thread.h"
#include "comm/autobuffer.h"

struct LongLinkConfItem{
	int enablexlog;
	int isAuth;
	std::string authInfo;
	std::string work_dir;
	int interval;
	int enableKeepalive;
	std::string longlinkhost;
	std::string shortlinkhost;
};

struct MsgItem{
	int head_length;
    int client_version;
    int cmdid;
    int seq;
    int body_length;
    std::string Body;
};

class MarsManager{

public:
	static MarsManager& Instance();
	bool Req2Buf(uint32_t _taskid, void* const _user_context, AutoBuffer& _outbuffer, AutoBuffer& _extend, int& _error_code, const int _channel_select);
	int Buf2Resp(uint32_t _taskid, void* const _user_context, const AutoBuffer& _inbuffer, const AutoBuffer& _extend, int& _error_code, const int _channel_select);
	int OnTaskEnd(uint32_t _taskid, void* const _user_context, int _error_type, int _error_code);
	void OnPush(uint64_t _channel_id, uint32_t _cmdid, uint32_t _taskid, const AutoBuffer& _body, const AutoBuffer& _extend);

	void setClientVersion(uint32_t _client_version);
	void setShortLinkDebugIP(const std::string& _ip, unsigned short _port);
	void setShortLinkPort(unsigned short _port);
	void setLongLinkAddress(const std::string& _ip, unsigned short _port, const std::string& _debug_ip = "");
	void start();

	//int startTask(CGITask* task);

	void __Init();
public:
	LongLinkConfItem mLongLinkConfItem;
	MsgItem mMsgItem;
protected:
	MarsManager();
	~MarsManager();

};

#endif //__H_MARS_MANAGER_H__
