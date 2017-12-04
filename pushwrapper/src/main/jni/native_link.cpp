#include "native_link.h"
#include "MarsManager.h"
/*
 * Class:     com_panda_org_pushwrapper_core
 * Method:    LinkCoreInit
 * Signature: ((Lcom/panda/org/pushwrapper/aidl/LongLinkConfItem;))I
 */
JNIEXPORT jint JNICALL Java_com_panda_org_pushwrapper_core_LinkCoreInit
  (JNIEnv *env, jobject thiz, jobject obj){

    jclass jclazz = env->GetObjectClass(JNI_GET_CLASS_OBJ(JAVA_CLASS_LongLinkConfItem));

	jfieldID jauthInfo = JNI_GET_FIELD_STR_ID_NAME("authInfo");
	jfieldID jwork_dir = JNI_GET_FIELD_STR_ID_NAME("work_dir");
	jfieldID jlonglinkhost = JNI_GET_FIELD_STR_ID_NAME("longlinkhost");
	jfieldID jshortlinkhost = JNI_GET_FIELD_STR_ID_NAME("shortlinkhost");

	jfieldID jenablexlog = JNI_GET_FIELD_INT_ID_NAME("enablexlog");
	jfieldID jisAuth = JNI_GET_FIELD_INT_ID_NAME("isAuth");
	jfieldID jinterval = JNI_GET_FIELD_INT_ID_NAME("interval");
	jfieldID jenableKeepalive = JNI_GET_FIELD_INT_ID_NAME("enableKeepalive");

	jstring authInfo = (jstring)JNI_GET_OBJ_FIELD_ID(jauthInfo);
	jstring work_dir = (jstring)JNI_GET_OBJ_FIELD_ID(jwork_dir);
	jstring longlinkhost = (jstring)JNI_GET_OBJ_FIELD_ID(jlonglinkhost);
	jstring shortlinkhost = (jstring)JNI_GET_OBJ_FIELD_ID(jshortlinkhost);

    MarsManager::Instance().mLongLinkConfItem.enablexlog = JNI_GET_INT_FIELD_ID(jenablexlog);
    MarsManager::Instance().mLongLinkConfItem.isAuth=JNI_GET_INT_FIELD_ID(jisAuth);
    MarsManager::Instance().mLongLinkConfItem.interval=JNI_GET_INT_FIELD_ID(jinterval);
    MarsManager::Instance().mLongLinkConfItem.enableKeepalive=JNI_GET_INT_FIELD_ID(jenableKeepalive);

    jstring jsauthinfo = (jstring)JNI_GET_OBJ_FIELD_ID(jauthInfo);
    MarsManager::Instance().mLongLinkConfItem.authInfo =jstringToStdstring(env, jsauthinfo);

    jstring jsworkdir = (jstring)JNI_GET_OBJ_FIELD_ID(jwork_dir);
    MarsManager::Instance().mLongLinkConfItem.work_dir =jstringToStdstring(env, jsworkdir);

    jstring jslonglinkhost = (jstring)JNI_GET_OBJ_FIELD_ID(jlonglinkhost);
    MarsManager::Instance().mLongLinkConfItem.longlinkhost =jstringToStdstring(env, jslonglinkhost);

    jstring jsshorthost = (jstring)JNI_GET_OBJ_FIELD_ID(jshortlinkhost);
    MarsManager::Instance().mLongLinkConfItem.shortlinkhost =jstringToStdstring(env, jsshorthost);

    MarsManager::Instance().m_pPushMsgProc=OnPushMsgProc;
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
