#include "native_link.h"
/*
 * Class:     com_panda_org_pushwrapper_core
 * Method:    LinkCoreInit
 * Signature: ((Lcom/panda/org/pushwrapper/aidl/LongLinkConfItem;))I
 */
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_LinkCoreInit
  (JNIEnv *env, jobject thiz, jobject confitem){

    return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    LinkCoreStart
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_LinkCoreStart
(JNIEnv *env, jobject thiz){
    return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    ResetLongLink
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_ResetLongLink
(JNIEnv *env, jobject thiz){
    return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    IsLongLinkConnect
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_IsLongLinkConnect
(JNIEnv *env, jobject thiz){
    return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    OnForeground
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_OnForeground
(JNIEnv *env, jobject thiz){

	return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    StartPushMsg
* Signature: (Lcom/panda/org/pushwrapper/aidl/MsgItem;)I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_StartPushMsg
(JNIEnv *env, jobject thiz, jobject msgitem){
    return 0;
}

/*
* Class:     com_panda_org_pushwrapper_core
* Method:    DestroyLink
* Signature: ()I
*/
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_DestroyLink
(JNIEnv *env, jobject thiz){
    return 0;
}

static JNINativeMethod mLinkMethods[] = {
	{ "LinkCoreInit", "(Lcom/panda/org/pushwrapper/aidl/LongLinkConfItem;)I", (void *)Java_com_panda_org_pushwrapper_core_LinkCoreInit },
    { "LinkCoreStart", "()I", (void *)Java_com_panda_org_pushwrapper_core_LinkCoreStart },
    { "ResetLongLink", "()I", (void *)Java_com_panda_org_pushwrapper_core_ResetLongLink },
    { "IsLongLinkConnect", "()I", (void *)Java_com_panda_org_pushwrapper_core_IsLongLinkConnect },
    { "OnForeground", "()I", (void *)Java_com_panda_org_pushwrapper_core_OnForeground },
    { "StartPushMsg", "(Lcom/panda/org/pushwrapper/aidl/MsgItem;)I", (void *)Java_com_panda_org_pushwrapper_core_StartPushMsg },
    { "DestroyLink", "()I", (void *)Java_com_panda_org_pushwrapper_core_DestroyLink }
};

int register_android_jni_link_module(JNIEnv* env, jclass clazz)
{
	return jniRegisterNativeMethods(env, clazz, mLinkMethods, sizeof(mLinkMethods) / sizeof(mLinkMethods[0]));
}
