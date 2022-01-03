package com.karashok.avstudydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.karashok.avstudydemo.push.LivePusher;

public class PushActivity extends AppCompatActivity {

    private static final String URL = "rtmp://49.232.167.72:1935/live/jason";

    private boolean living = false;
    private Button pushBtn;
    private LivePusher live;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        SurfaceView surfaceView = findViewById(R.id.surface);
        //相机图像的预览
        live = new LivePusher(surfaceView.getHolder());
        pushBtn = findViewById(R.id.btn_push);
        pushBtn.setOnClickListener(clickListener);
        findViewById(R.id.btn_camera_switch)
                .setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_camera_switch) {
                live.switchCamera();
            } else if (viewId == R.id.btn_push) {
                if (living) {
                    living = false;
                    live.stopPush();
                    pushBtn.setText("开始直播");
                } else  {
                    living = true;
                    live.startPush(URL);
                    pushBtn.setText("停止直播");
                }
            }
        }
    };
}