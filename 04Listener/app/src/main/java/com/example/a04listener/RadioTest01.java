package com.example.a04listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioTest01 extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_test01);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        textView1 = findViewById(R.id.textView4);
        // 设置监听器 对group注册监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // 判断单选框的状态
                if (radioButton1.isChecked()) {
                    textView1.setText("你选中的是男");
                } else if (radioButton2.isChecked()) {
                    textView1.setText("你选中的是女");
                }
            }
        });
    }
}