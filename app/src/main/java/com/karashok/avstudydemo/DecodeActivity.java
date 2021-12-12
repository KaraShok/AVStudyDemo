package com.karashok.avstudydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.karashok.avstudydemo.ffmpeg_utils.FFVideoU;

import java.io.File;

public class DecodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode);
        findViewById(R.id.decode_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String bashPath = getExternalFilesDir("").getAbsolutePath() + File.separator;
                        Log.d("karashok"," " + bashPath);
                        String inputStr = bashPath + "demo.mp4";
                        String outputStr = bashPath + "ot.yuv";
                        FFVideoU.decode(inputStr,outputStr);
                    }
                });
    }
}