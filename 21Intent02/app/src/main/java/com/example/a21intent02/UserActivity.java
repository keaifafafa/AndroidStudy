package com.example.a21intent02;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvInfo = findViewById(R.id.textView4);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvInfo.setText(username + "你好，欢迎使用本系统！");
    }
}