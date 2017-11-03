#include "native_support.h"

BOOLEAN support_comm_is_utf8(const CHAR* str)
{
    BOOLEAN IsUTF8 = CN_TRUE;
    INT8U* start = (INT8U*)str, *end;
    INT32S size = 0;

    if (CN_NULL == str)
    {
        return CN_FALSE;
    }
    size = strlen(str);
    end = (INT8U*)(str + size);

    while (start < end)
    {
        if (*start < 0x80) // (10000000): value less then 0x80 ASCII char
        {
            start++;
        }
        else if (*start < (0xC0)) // (11000000): between 0x80 and 0xC0 UTF-8 char
        {
            IsUTF8 = CN_FALSE;
            break;
        }
        else if (*start < (0xE0)) // (11100000): 2 bytes UTF-8 char
        {
            if (start >= end - 1)
            {
                break;
            }
            if ((start[1] & (0xC0)) != 0x80)
            {
                IsUTF8 = CN_FALSE;
                break;
            }
            start += 2;
        }
        else if (*start < (0xF0)) // (11110000): 3 bytes UTF-8 char
        {
            if (start >= end - 2)
            {
                break;
            }
            if ((start[1] & (0xC0)) != 0x80 || (start[2] & (0xC0)) != 0x80)
            {
                IsUTF8 = CN_FALSE;
                break;
            }
            start += 3;
        }
        else
        {
            IsUTF8 = CN_FALSE;
            break;
        }
    }
    return IsUTF8;
}


jbyteArray as_byte_array(JNIEnv *env,char* buf, int len) {
    jbyteArray array = env->NewByteArray(len);
    env->SetByteArrayRegion(array, 0, len, reinterpret_cast<jbyte*>(buf));
    return array;
}

unsigned char* as_unsigned_char_array(JNIEnv *env,jbyteArray array) {
    int len = env->GetArrayLength(array);
    unsigned char* buf = new unsigned char[len];
    env->GetByteArrayRegion(array, 0, len, reinterpret_cast<jbyte*>(buf));
    return buf;
}

INT32S cn_strlen(const CHAR *src)
{
    return strlen((const char*)src);
}