#include <jni.h>
#include <string>
#include "x264_config.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_karashok_pusher_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = X264_POINTVER;
    return env->NewStringUTF(hello.c_str());
}