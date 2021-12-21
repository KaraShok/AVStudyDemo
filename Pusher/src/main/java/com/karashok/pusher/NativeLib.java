package com.karashok.pusher;

public class NativeLib {

    // Used to load the 'pusher' library on application startup.
    static {
        System.loadLibrary("pusher");
    }

    /**
     * A native method that is implemented by the 'pusher' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}