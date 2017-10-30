LOCAL_PATH :=$(call my-dir)
LOCAL_MARS_PATH := $(LOCAL_PATH)
REMOTE_MARS_PATH := ../../..
include $(CLEAR_VARS)

# 先引入mars库
include $(LOCAL_MARS_PATH)/mars/Android.mk

# 导入mars库
LOCAL_STATIC_LIBRARIES += stn sdt appcomm baseevent static_xlog comm ssl crypto

LOCAL_LDFLAGS += -Wl,--gc-sections,--version-script=$(REMOTE_MARS_PATH)/mars/update/mars-master/mars/log/jni/export.exp
LOCAL_LDFLAGS += -Wl,--gc-sections,--version-script=jni/mars/include/export.exp
include $(LOCAL_PATH)/define_macros.mk

# mars 头文件
LOCAL_INCLUDE := $(REMOTE_MARS_PATH)/mars/update/mars-master/mars


