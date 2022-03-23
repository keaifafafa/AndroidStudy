package com.example.a04listener;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

/**
 * 三个按钮指向同一对象
 */
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv1;
    Button btn01, btn02, btn03;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = findViewById(R.id.textView2);
        btn01 = findViewById(R.id.button5);
        btn02 = findViewById(R.id.button6);
        btn03 = findViewById(R.id.button7);
        imageButton = findViewById(R.id.imageButton);
        // 绑定事件
        btn01.setOnClickListener(this::onClick);
        btn02.setOnClickListener(this::onClick);
        btn03.setOnClickListener(this::onClick);
        imageButton.setOnClickListener(this::onClick);
        // 给左上角图标的左边加上一个返回的图标 。
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        // 对三个按钮的单击事件进行处理
        int id = view.getId();
        if (id == btn01.getId()) {
            tv1.setTextColor(Color.rgb(255, 0, 0));
        } else if (id == btn02.getId()) {
            tv1.setTextColor(Color.rgb(0, 255, 0));
        } else if (id == btn03.getId()) {
            tv1.setTextColor(Color.rgb(0, 0, 255));
        }
        if (id == R.id.imageButton) {
            imageButton.setImageResource(R.drawable.p3);
        }
    }

    /**
     * 实现随机按钮
     */
    public void getRandomColor(View view) {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        tv1.setTextColor(Color.rgb(red, green, blue));
    }
}