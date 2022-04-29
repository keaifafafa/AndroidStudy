package com.example.a21loginintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login, btn_cancel;
    EditText et_name, et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.login_button);
        btn_cancel = findViewById(R.id.cancel_button);
        et_name = findViewById(R.id.editText_username);
        et_pwd = findViewById(R.id.editText_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_name.getText().toString();
                String password = et_pwd.getText().toString();
                // 用户名和密码先写死
                if (username.equals("hello") && password.equals("world")) {
                    // 创建Intent
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    // 将数据
                    intent.putExtra("username", username);
                    startActivity(intent);
                    // 方式二使用Bundle
                } else {
                    Toast.makeText(MainActivity.this, "账号或密码不正确！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 取消按钮
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_name.setText("");
                et_pwd.setText("");
            }
        });


    }
}