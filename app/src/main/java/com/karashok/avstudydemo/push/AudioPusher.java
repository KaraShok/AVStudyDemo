package com.karashok.avstudydemo.push;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import com.karashok.avstudydemo.ffmpeg_utils.PushU;

/**
 * @author zhangyaozhong @ Zhihu Inc.
 * @since 01-01-2022
 */
public class AudioPusher extends IPusher{

    private AudioParam audioParam;
    private AudioRecord audioRecord;
    private boolean isPushing = false;
    private int minBufferSize;
    private PushU pushNative;

    public AudioPusher(AudioParam audioParam, PushU pushNative) {
        this.audioParam = audioParam;
        this.pushNative = pushNative;

        int channelConfig = audioParam.getChannel() == 1 ?
                AudioFormat.CHANNEL_IN_MONO : AudioFormat.CHANNEL_IN_STEREO;
        //最小缓冲区大小
        minBufferSize = AudioRecord.getMinBufferSize(audioParam.getSampleRateInHz(), channelConfig, AudioFormat.ENCODING_PCM_16BIT);
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                audioParam.getSampleRateInHz(),
                channelConfig,
                AudioFormat.ENCODING_PCM_16BIT, minBufferSize);
    }


    @Override
    public void startPush() {
        isPushing = true;
        //启动一个录音子线程
        new Thread(new AudioRecordTask()).start();
    }

    @Override
    public void stopPush() {
        isPushing = false;
        audioRecord.stop();
    }

    @Override
    public void release() {
        if(audioRecord != null){
            audioRecord.release();
            audioRecord = null;
        }
    }

    class AudioRecordTask implements Runnable{

        @Override
        public void run() {
            //开始录音
            audioRecord.startRecording();

            while(isPushing){
                //通过AudioRecord不断读取音频数据
                byte[] buffer = new byte[minBufferSize];
                int len = audioRecord.read(buffer, 0, buffer.length);
                if(len > 0){
                    //传给Native代码，进行音频编码
                    pushNative.fireAudio(buffer, len);
                }
            }
        }

    }
}
