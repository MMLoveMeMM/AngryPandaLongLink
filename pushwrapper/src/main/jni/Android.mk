LOCAL_PATH := $(call my-dir)
MAIN_PATH := $(LOCAL_PATH)
PROJECT_PATH := ../../../..

$(warning $(MAIN_PATH))
$(warning $(PROJECT_PATH))

LOCAL_C_INCLUDES += system/core/include/cutils

##########################################################################
include $(CLEAR_VARS)

#mars
include $(MAIN_PATH)/mars/include/Android.mk
##########################################################################

#reset
LOCAL_PATH := $(MAIN_PATH)

#middleware
include $(CLEAR_VARS)

LOCAL_DISABLE_FATAL_LINKER_WARNINGS := true
LOCAL_LDLIBS += -llog -lz

#mars
LOCAL_STATIC_LIBRARIES += stn sdt appcomm baseevent static_xlog comm ssl crypto

LOCAL_MODULE := linkcore

			
LOCAL_C_INCLUDES := $(MAIN_PATH) \
                    $(MAIN_PATH)/$(PROJECT_PATH)/mars \
                    $(MAIN_PATH)/../../../mars \
                    $(MAIN_PATH)/../../.. \
                    $(MAIN_PATH)/mars \
                    $(MAIN_PATH)/mars/include \
                    $(MAIN_PATH)/mars/src

#$(warning $(LOCAL_C_INCLUDES))

# mars
# mars
LOCAL_MARS_SRC_DIR_LIST := $(wildcard $(MAIN_PATH)/mars/src/*.cpp)
LOCAL_MARS_SRC_DIR := $(LOCAL_MARS_SRC_DIR_LIST:$(MAIN_PATH)/%=%)

LOCAL_MARS_DIR_LIST := $(wildcard $(MAIN_PATH)/mars/*.cpp)
LOCAL_MARS_DIR := $(LOCAL_MARS_DIR_LIST:$(MAIN_PATH)/%=%)
					
$(warning $(LOCAL_JNI_DIR_IM))
LOCAL_SRC_FILES := native_core.cpp \
                    native_support.cpp \
                    native_link.cpp

LOCAL_SRC_FILES += $(LOCAL_MARS_SRC_DIR) \
					$(LOCAL_MARS_DIR)

include $(MAIN_PATH)/mars/include/JNI.mk
LOCAL_LDLIBS += -latomic
LOCAL_SRC_FILES += import.cc

LOCAL_CFLAGS += -fpermissive -Wwrite-strings -Wparentheses -fexceptions

include $(BUILD_SHARED_LIBRARY)
##########################################################################