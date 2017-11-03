LOCAL_PATH :=$(call my-dir)

include $(CLEAR_VARS)
LIB_MARS_PATH := ../../../../../..
# mars库的路径
MARS_LIBS_PATH := $(LIB_MARS_PATH)/mars/update/mars-master/mars/libraries/mars_android_sdk/mars_libs

TARGET_ARCH_ABI := armeabi

LOCAL_MODULE := comm
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarscomm.a
#$(warning $(LOCAL_SRC_FILES))
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := baseevent
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarsbaseevent.a

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := appcomm
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarsappcomm.a

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := stn
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarsstn.a

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := sdt
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarssdt.a

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := static_xlog
LOCAL_SRC_FILES := $(MARS_LIBS_PATH)/$(TARGET_ARCH_ABI)/libmarsxlog.a

include $(PREBUILT_STATIC_LIBRARY)



