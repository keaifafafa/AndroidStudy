package com.example.a02_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 认识 Android 的生命周期
 */
public class MainActivity extends AppCompatActivity {
    // 创建方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 先获取对象
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        Log.i("TAG", "onCreate");
        // 绑定事件【创建匿名对象，监听器】
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "这是一个information信息");
                Log.d("JSJ", "这是一个Debug信息");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "onRestart");
    }


}