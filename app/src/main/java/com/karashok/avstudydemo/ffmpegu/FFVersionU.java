package com.karashok.avstudydemo.ffmpegu;

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
    }

    public static native String avcodecVersion();
}
