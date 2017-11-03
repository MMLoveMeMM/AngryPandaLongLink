#ifndef __H_NATIVE_LINK_H__
#define __H_NATIVE_LINK_H__
#include<jni.h>
#include "native_core.h"
#include <stdlib.h>
#include <time.h>
#include <stdio.h>
#include <android/log.h>

#ifdef __cplusplus
extern "C"
{
#endif
int register_android_jni_link_module(JNIEnv* env, jclass clazz);
/*
 * Class:     com_panda_org_pushwrapper_core
 * Method:    LinkCoreInit
 * Signature: (Lcom/panda/org/pushwrapper/aidl/LongLinkConfItem;)I
 */
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_LinkCoreInit
  (JNIEnv *, jobject, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    LinkCoreStart
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_LinkCoreStart
(JNIEnv *, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    ResetLongLink
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_ResetLongLink
(JNIEnv *, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    IsLongLinkConnect
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_IsLongLinkConnect
(JNIEnv *, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    OnForeground
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_OnForeground
(JNIEnv *, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    StartPushMsg
* Signature: (Lcom/panda/org/pushwrapper/aidl/MsgItem;)I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_StartPushMsg
(JNIEnv *, jobject, jobject);

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    DestroyLink
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_DestroyLink
(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif //__H_NATIVE_LINK_H__