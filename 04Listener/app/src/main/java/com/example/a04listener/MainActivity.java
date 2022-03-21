package com.example.a04listener;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 成员变量
    TextView tv1;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        tv1.setTextColor(Color.RED);
        tv1.setText("中国");
        // 添加监听器
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setTextColor(Color.BLACK);
            }
        });
        // 方式二 使用匿名类的实名对象作为监听器对象
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(listener);
        // 方式三 使用内部类对象作为监听器对象
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new BtnClick());
        // 方式四 使用this方式来实现
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this::onClick);
    }

    // 实现接口的抽象方法
    @Override
    public void onClick(View view) {
        // 改变字体的大小
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }

    // 定义内部类
    class BtnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            tv1.setTextColor(Color.GREEN);
        }
    }

    // 实例监听对象
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv1.setTextColor(Color.rgb(200, 10, 100));
        }
    };
}