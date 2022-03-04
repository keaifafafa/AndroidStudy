package com.example.a01_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 中英文切换标志
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取对象
        TextView textView = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);
        // 为按钮添加监听器【匿名内部类方式】
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 中文
                if (flag) {
                    textView.setText(R.string.name_cn);
                } else {
                    textView.setText(R.string.name);
                }
                // 更新标志位
                flag = !flag;
            }
        });
    }
}