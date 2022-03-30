package com.example.a07textedit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextTextPersonName);
        et2 = findViewById(R.id.editTextTextPersonName2);
        /**
         * 获得和失去焦点
         */
        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                // 得到焦点变红色，反之变绿色
                if (b) {
                    et1.setTextColor(Color.RED);
                } else {
                    et1.setTextColor(Color.GREEN);
                }
            }
        });

        /**
         * 绑定按下键盘事件
         */
        et2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                // 如果按下了
                if (i == KeyEvent.KEYCODE_ENTER) {
                    String str = et2.getText().toString().trim();
                    int age = Integer.parseInt(str);
                    // 年龄不合法
                    if (age >= 150) {
                        Toast.makeText(MainActivity.this, "不合法", Toast.LENGTH_SHORT).show();
                        et2.selectAll();
                    }
                }
                return false;
            }
        });
    }
}