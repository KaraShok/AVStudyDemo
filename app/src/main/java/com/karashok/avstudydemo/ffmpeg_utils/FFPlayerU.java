package com.karashok.avstudydemo.ffmpeg_utils;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.Log;
import android.view.Surface;

/**
 * @author zhangyaozhong @ Zhihu Inc.
 * @since 09-21-2021
 */
public class FFPlayerU {

    public static native void render(String input, Surface surface);

    public static native void sound(String input, String output);

    public static native void play(String input, Surface surface);

    /**
     * 创建一个AudioTrac对象，用于播放
     * @param nb_channels
     * @return
     */
    public static AudioTrack createAudioTrack(int sampleRateInHz, int nb_channels){
        //固定格式的音频码流
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        Log.i("player", "nb_channels: " + nb_channels);
        //声道布局
        int channelConfig;
        if(nb_channels == 1){
            channelConfig = AudioFormat.CHANNEL_OUT_MONO;
        }else if(nb_channels == 2){
            channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
        }else{
            channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
        }

        int bufferSizeInBytes = AudioTrack.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);

        AudioTrack audioTrack = new AudioTrack(
                AudioManager.STREAM_MUSIC,
                sampleRateInHz, channelConfig,
                audioFormat,
                bufferSizeInBytes, AudioTrack.MODE_STREAM);
        //播放
        //audioTrack.play();
        //写入PCM
        //audioTrack.write(audioData, offsetInBytes, sizeInBytes);
        return audioTrack;
    }
}
