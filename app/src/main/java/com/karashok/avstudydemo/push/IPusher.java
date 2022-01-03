package com.karashok.avstudydemo.push;

/**
 * @author zhangyaozhong @ Zhihu Inc.
 * @since 01-01-2022
 */
public abstract class IPusher {
    public abstract void startPush();

    public abstract void stopPush();

    public abstract void release();
}
