package com.karashok.avstudydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.karashok.avstudydemo.ffmpegu.FFVersionU;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("demoffmpeg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.sample_text);
        tv.setText(FFVersionU.avcodecVersion());

        findViewById(R.id.intent_activity_decode_btn)
                .setOnClickListener(clickListener);
        findViewById(R.id.intent_activity_player_btn)
                .setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vId = v.getId();
            if (vId == R.id.intent_activity_decode_btn) {
                startActivity(new Intent(MainActivity.this,DecodeActivity.class));
            } else if (vId == R.id.intent_activity_player_btn) {
                startActivity(new Intent(MainActivity.this,PlayerActivity.class));
            }
        }
    };
}