#include "../jni/com_karashok_avstudydemo_ffmpegu_FFVersionU.h"

#include <jni.h>
#include "include/libavutil/avutil.h"

JNIEXPORT jstring JNICALL Java_com_karashok_avstudydemo_ffmpegu_FFVersionU_avcodecVersion(JNIEnv *env, jclass jcls) {
    return (*env)->NewStringUTF(env,av_version_info());
}