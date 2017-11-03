#ifndef __H_NATIVE_SPPORTS_H__
#define __H_NATIVE_SPPORTS_H__

#ifdef __cplusplus
extern "C"
{
#endif

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<android/log.h>
#include <jni.h>
#include "native_core.h"

#ifdef __cplusplus
extern "C"
{
#endif

#define CN_NULL     0
#define  CN_FALSE 0
#define CN_TRUE    1

typedef char CHAR;
typedef unsigned char BOOLEAN;
typedef unsigned char INT8U;                    /* Unsigned  8 bit quantity*/
typedef signed char INT8S;                    /* Signed    8 bit quantity*/
typedef unsigned short INT16U;                   /* Unsigned 16 bit quantity*/
typedef signed short INT16S;                   /* Signed   16 bit quantity*/
typedef unsigned int INT32U;                   /* Unsigned 32 bit quantity*/
typedef signed int INT32S;                   /* Signed   32 bit quantity*/
typedef double INT32D;
#if defined(COMPILE_64BITS)
typedef unsigned long 	    INT64U;					  /* Unsigned 64 bit quantity*/
typedef long  			    INT64S;					  /* Unsigned 64 bit quantity*/
#else
typedef unsigned long long INT64U;                      /* Unsigned 64 bit quantity*/
typedef long long INT64S;                      /* Unsigned 64 bit quantity*/
#endif
typedef float FP32;                     /* Single precision floating point*/
typedef double FP64;                     /* Double precision floating point*/

#define TAG "ANGRYPADANAV"
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, TAG, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__))

BOOLEAN support_comm_is_utf8(const CHAR *str);

jbyteArray string_char_emoji_convert_bytearray(JNIEnv *env, char *ret_msg);
jbyteArray string_emoji_convert_bytearray(JNIEnv *env, const char *content);

INT32S cn_strlen(const CHAR *src);

#ifdef __cplusplus
}
#endif
#endif //__H_NATIVE_SPPORTS_H__