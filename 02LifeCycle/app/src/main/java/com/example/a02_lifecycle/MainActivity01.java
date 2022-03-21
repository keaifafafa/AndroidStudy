package com.example.a02_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        Log.d("TAg", "MainActivity01执行了onCreate");

        // 将其添加到 List集合中
        ActivityManager.addActivity(this);

        // 跳转视图按钮
        Button btn = findViewById(R.id.button);

        // 关闭按钮
        Button closeBtn = findViewById(R.id.button3);

        // 跳转视图按钮监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 参数一是当前视图，二是需要跳转的视图
                Intent intent = new Intent(MainActivity01.this, MainActivity02.class);
                // 开启另一个视图【需要跳转的视图】
                startActivity(intent);
            }
        });

        // 关闭按钮监听器
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}