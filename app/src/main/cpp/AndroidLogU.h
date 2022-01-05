//
// Created by KaraShok Zhang on 2022/1/5.
//
#include <android/log.h>

#ifndef AVSTUDYDEMO_ANDROIDLOGU_H
#define AVSTUDYDEMO_ANDROIDLOGU_H

#define LogE(tag,format, ...)  __android_log_print(ANDROID_LOG_ERROR, tag, format, ##__VA_ARGS__)
#define LogI(tag,format, ...)  __android_log_print(ANDROID_LOG_INFO,  tag, format, ##__VA_ARGS__)

#endif //AVSTUDYDEMO_ANDROIDLOGU_H
