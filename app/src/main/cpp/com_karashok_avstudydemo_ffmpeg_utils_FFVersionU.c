#include "../jni/com_karashok_avstudydemo_ffmpeg_utils_FFVersionU.h"

#include <jni.h>
#include "include/libavutil/avutil.h"

JNIEXPORT jstring JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_FFVersionU_avcodecVersion(JNIEnv *env, jclass jcls) {
    return (*env)->NewStringUTF(env,av_version_info());
}