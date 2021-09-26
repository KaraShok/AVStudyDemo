package com.karashok.avstudydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Surface;
import android.view.View;

import com.karashok.avstudydemo.ffmpegu.FFPlayerU;
import com.karashok.avstudydemo.widget.VideoView;

import java.io.File;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        videoView = findViewById(R.id.video_view);
        findViewById(R.id.start_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String bashPath = getExternalFilesDir("").getAbsolutePath() + File.separator;
                        String inPutStr = bashPath + "demo.mp4";
                        //Surface传入到Native函数中，用于绘制
                        Surface surface = videoView.getHolder().getSurface();
                        FFPlayerU.render(inPutStr,surface);
                        String outPutStr = bashPath + "demoSoundOutput.mp4";
                        FFPlayerU.sound(inPutStr,outPutStr);
                    }
                });
    }
}