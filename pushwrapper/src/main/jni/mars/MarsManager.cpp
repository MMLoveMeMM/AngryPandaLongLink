#include "MarsManager.h"
#include "comm/projdef.h"
#include "boost/bind.hpp"
#include "baseevent/base_logic.h"
#include "stn/stn_logic.h"
#include "stn/proto/stnproto_logic.h"
#include "stn_callback.h"
#include "app_callback.h"


MarsManager::MarsManager(){

}

MarsManager::~MarsManager(){

}

MarsManager& MarsManager::Instance()
{
	static MarsManager instance_;
	return instance_;
}

void MarsManager::__Init(){
	mars::stn::SetCallback(mars::stn::StnCallBack::Instance());
	mars::app::SetCallback(mars::app::AppCallBack::Instance());
	mars::baseevent::OnCreate();
}

bool MarsManager::Req2Buf(uint32_t _taskid, void* const _user_context, AutoBuffer& _outbuffer, AutoBuffer& _extend, int& _error_code, const int _channel_select){

}

int MarsManager::Buf2Resp(uint32_t _taskid, void* const _user_context, const AutoBuffer& _inbuffer, const AutoBuffer& _extend, int& _error_code, const int _channel_select){

}

int MarsManager::OnTaskEnd(uint32_t _taskid, void* const _user_context, int _error_type, int _error_code){

}

void MarsManager::OnPush(uint64_t _channel_id, uint32_t _cmdid, uint32_t _taskid, const AutoBuffer& _body, const AutoBuffer& _extend){

}

void MarsManager::setClientVersion(uint32_t _client_version){
	mars::stn::SetClientVersion(_client_version);
}

void MarsManager::setShortLinkDebugIP(const std::string& _ip, unsigned short _port){
	mars::stn::SetShortlinkSvrAddr(_port, _ip);
}

void MarsManager::setShortLinkPort(unsigned short _port){
	mars::stn::SetShortlinkSvrAddr(_port, "");
}

void MarsManager::setLongLinkAddress(const std::string& _ip, unsigned short _port, const std::string& _debug_ip){
	std::vector<uint16_t> ports;
	ports.push_back(_port);
	mars::stn::SetLonglinkSvrAddr(_ip, ports, _debug_ip);
}

void MarsManager::start(){
	mars::baseevent::OnForeground(true);
	mars::stn::MakesureLonglinkConnected();
}

/*int MarsManager::startTask(CGITask* task){
	mars::stn::Task ctask;
		ctask.cmdid = task->cmdid_;
		ctask.channel_select = task->channel_select_;
		ctask.shortlink_host_list.push_back(task->host_);
		ctask.cgi = task->cgi_;
		ctask.user_context = (void*)task;
		mars::stn::StartTask(ctask);
		map_task_[ctask.taskid] = task;
		return ctask.taskid;
}*/
