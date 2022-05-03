package com.example.a21intent02;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button reg_btn1, reg_btn2;
    EditText reg_name, reg_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_btn1 = findViewById(R.id.button3);
        reg_btn2 = findViewById(R.id.button2);
        reg_name = findViewById(R.id.editText_username);
        reg_pwd = findViewById(R.id.editText_password);
        // 注册
        reg_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 用户名和密码不能为空
                if (TextUtils.isEmpty(reg_name.getText().toString()) || TextUtils.isEmpty(reg_pwd.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    String name = reg_name.getText().toString();
                    String pwd = reg_pwd.getText().toString();
                    // 保存用户名和密码
                    Intent intent = new Intent();
                    intent.putExtra("username", name);
                    intent.putExtra("password", pwd);
                    // 将intent传到登录界面，设置结果码
                    setResult(200, intent);
                    finish();
                }
            }
        });

        // 取消
        reg_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 直接关闭
                finish();
            }
        });

    }
}