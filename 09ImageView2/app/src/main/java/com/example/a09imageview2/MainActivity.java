package com.example.a09imageview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button btnFirst, btnPre, btnNext, btnLast;
    // 存放图片id
    int[] images = {R.drawable.tu1, R.drawable.tu2, R.drawable.tu3, R.drawable.tu4, R.drawable.tu5, R.drawable.tu6, R.drawable.tu7};
    // 图片数组的大小
    int imLength = images.length;
    // 启始数组下标
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        btnFirst = findViewById(R.id.button);
        btnPre = findViewById(R.id.button2);
        btnNext = findViewById(R.id.button3);
        btnLast = findViewById(R.id.button4);
        // 绑定
        btnFirst.setOnClickListener(this);
        btnPre.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnLast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                index = 0;
                imageView.setImageResource(images[index]);
                break;
            case R.id.button2:
                index--;
                if (index < 0) {
                    index = 0;
                }
                imageView.setImageResource(images[index]);
                break;
            case R.id.button3:
                index++;
                if (index >= imLength) {
                    index = imLength - 1;
                }
                imageView.setImageResource(images[index]);
                break;
            case R.id.button4:
                index = imLength - 1;
                imageView.setImageResource(images[index]);
                break;
        }
    }
}