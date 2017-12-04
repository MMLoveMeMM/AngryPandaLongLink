#include "Packet.h"
Packet::Packet()
{

}
Packet::~Packet()
{

}

uint32_t Packet::gethead_length()
{
    return head_length;
}
void Packet::sethead_length(uint32_t hl)
{
    head_length=hl;
}
uint32_t Packet::getclient_version()
{
    return client_version;
}
void Packet::setclient_version(uint32_t cv)
{
    client_version=cv;
}
uint32_t Packet::getcmdid()
{
    return cmdid;
}
void Packet::setcmdid(uint32_t cid)
{
    cmdid=cid;
}
uint32_t Packet::getseq()
{
    return seq;
}
void Packet::setseq(uint32_t s)
{
    seq=s;
}
uint32_t Packet::getbody_length()
{
    return body_length;
}
void Packet::setbody_length(uint32_t bl)
{
    body_length=bl;
}

std::string Packet::getbody()
{
    return body;
}
void Packet::setbody(std::string bd)
{
    body=bd;
}