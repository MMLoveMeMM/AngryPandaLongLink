#ifndef __H_PACKET_H__
#define __H_PACKET_H__
#include "comm/autobuffer.h"
#include "stn/stn.h"
class  Packet
{
public:
    Packet();
    ~Packet();

    uint32_t gethead_length();
    void sethead_length(uint32_t head_length);
    uint32_t getclient_version();
    void setclient_version(uint32_t client_version);
    uint32_t getcmdid();
    void setcmdid(uint32_t cmdid);
    uint32_t getseq();
    void setseq(uint32_t seq);
    uint32_t getbody_length();
    void setbody_length(uint32_t body_length);
    std::string getbody();
    void setbody(std::string bd);
public:
    uint32_t    head_length;
    uint32_t    client_version;
    uint32_t    cmdid;
    uint32_t    seq;
    uint32_t	body_length;
    std::string body;
};
#endif //__H_PACKET_H__