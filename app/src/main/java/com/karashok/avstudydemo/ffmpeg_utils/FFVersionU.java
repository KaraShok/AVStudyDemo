package com.karashok.avstudydemo.ffmpeg_utils;

/**
 * @author zhangyaozhong @ Zhihu Inc.
 * @since 09-21-2021
 */
public class FFVersionU {

    static {
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("avcodec");
        System.loadLibrary("avformat");
        System.loadLibrary("swscale");
        System.loadLibrary("postproc");
        System.loadLibrary("avfilter");
        System.loadLibrary("avdevice");
        System.loadLibrary("yuv");
        System.loadLibrary("x264");
        System.loadLibrary("faac");
        System.loadLibrary("rtmp");
    }

    public static native String avcodecVersion();
}
