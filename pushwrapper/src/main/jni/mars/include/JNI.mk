MARS_LOCAL_PATH_JNI := $(MAIN_PATH)/$(PROJECT_PATH)/mars
$(warning $(MARS_LOCAL_PATH_JNI))

include $(MARS_LOCAL_PATH_JNI)/mk_template/flags.mk

#LOCAL_SRC_FILES += $(MARS_LOCAL_PATH_JNI)/libraries/mars_android_sdk/jni/import.cc
#LOCAL_STATIC_LIBRARIES += stn sdt appcomm baseevent crypto static_xlog comm

#LOCAL_CPPFLAGS += -frtti
#LOCAL_CFLAGS += -Werror -Wextra -Wall -Wno-error=conversion -Wno-error=sign-conversion -Werror=sign-compare
#LOCAL_CFLAGS += -Wno-unused-parameter -Wno-missing-field-initializers
#LOCAL_CFLAGS +=  -fdata-sections

LOCAL_LDFLAGS += -Wl,--gc-sections,--version-script=$(MARS_LOCAL_PATH_JNI)/log/jni/export.exp

#LOCAL_C_INCLUDES += $(MARS_LOCAL_PATH_JNI)

include $(MARS_LOCAL_PATH_JNI)/libraries/mars_android_sdk/jni/define_macros.mk