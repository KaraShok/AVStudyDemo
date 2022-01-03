/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_karashok_avstudydemo_ffmpeg_utils_PushU */

#ifndef _Included_com_karashok_avstudydemo_ffmpeg_utils_PushU
#define _Included_com_karashok_avstudydemo_ffmpeg_utils_PushU
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    startPush
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_startPush
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    stopPush
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_stopPush
  (JNIEnv *, jobject);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    release
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_release
  (JNIEnv *, jobject);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    setVideoOptions
 * Signature: (IIII)V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_setVideoOptions
  (JNIEnv *, jobject, jint, jint, jint, jint);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    setAudioOptions
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_setAudioOptions
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    fireVideo
 * Signature: ([B)V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_fireVideo
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     com_karashok_avstudydemo_ffmpeg_utils_PushU
 * Method:    fireAudio
 * Signature: ([BI)V
 */
JNIEXPORT void JNICALL Java_com_karashok_avstudydemo_ffmpeg_1utils_PushU_fireAudio
  (JNIEnv *, jobject, jbyteArray, jint);

#ifdef __cplusplus
}
#endif
#endif
