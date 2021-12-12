package com.karashok.avstudydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.karashok.avstudydemo.ffmpeg_utils.PushStreamU;

import java.io.File;

public class PushStreamActivity extends AppCompatActivity {


    private EditText et_input;
    private EditText et_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_stream);
        et_input = (EditText)findViewById(R.id.et_input);
        et_output = (EditText)findViewById(R.id.et_output);
        findViewById(R.id.button_start)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputUrl = Environment.getExternalStorageDirectory().getPath() + File.separator + et_input.getText().toString();
                        String outputUrl = et_output.getText().toString();
                        PushStreamU.push(inputUrl,outputUrl);
                    }
                });
    }
}