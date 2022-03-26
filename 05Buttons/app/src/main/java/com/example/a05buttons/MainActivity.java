package com.example.a05buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 按钮操作
 */
public class MainActivity extends AppCompatActivity {
    RadioGroup rdg1;
    Button message;
    RadioButton btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdg1 = findViewById(R.id.radioGroup);
        message = findViewById(R.id.button);
        btn1 = findViewById(R.id.radioButton);
        btn2 = findViewById(R.id.radioButton2);
        btn3 = findViewById(R.id.radioButton3);
        btn4 = findViewById(R.id.radioButton4);
        // 添加选中监听器
        rdg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (btn2.isChecked()) {
                    message.setText("正确");
                } else {
                    message.setText("错误");
                }
            }
        });

    }


}