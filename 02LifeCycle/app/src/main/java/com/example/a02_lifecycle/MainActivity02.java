package com.example.a02_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将其添加到 List集合中
        ActivityManager.addActivity(this);

        // 设置试图布局界面
        setContentView(R.layout.activity_main02);

        // 关闭按钮
        Button btn = findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 全部从List中移除
                ActivityManager.removeAllActivity();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}