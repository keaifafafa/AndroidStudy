package com.example.a15myviewtitle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 将标题栏隐藏
        if (null != getSupportActionBar()) {
            getSupportActionBar().hide();
        }
    }
}