ifeq ($(APP_LOCAL_PATH)/build.conf, $(wildcard  $(APP_LOCAL_PATH)/build.conf))
include $(APP_LOCAL_PATH)/build.conf
endif

APP_ABI := ${_ARCH_}
#APP_STL := stlport_shared
APP_STL := c++_static
APP_PLATFORM := android-9
#APP_CPPFLAGS +=-std=gnu++11 
APP_CPPFLAGS +=-std=c++11
NDK_TOOLCHAIN_VERSION := clang
APP_MODULES :=$(SELF_LOCAL_MODULE)
$(info 'info APP_MODULES = $(APP_MODULES)')
