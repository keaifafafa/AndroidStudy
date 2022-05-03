package com.example.a21intent02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_login, btn_cancel, btn_register;
    EditText username, password;
    String loginUser, loginPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.button);
        btn_cancel = findViewById(R.id.button2);
        btn_register = findViewById(R.id.button3);
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        // 注册监听器
        btn_login.setOnClickListener(this::onClick);
        btn_cancel.setOnClickListener(this::onClick);
        btn_register.setOnClickListener(this::onClick);

    }

    /**
     * 实现抽象方法
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        // 先判断按钮类型
        // 如果是登陆
        if (view.getId() == btn_login.getId()) {
            if (username.getText().toString().equals(loginUser) && password.getText().toString().equals(loginPwd)) {
                // 跳转成功页面
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                // 携带参数
                intent.putExtra("username", loginUser);
                startActivity(intent);
            } else {
                // 否则 打印失败
                Toast.makeText(this, "登录失败，用户名或密码有误！", Toast.LENGTH_SHORT).show();
            }
        }
        // 取消操作
        else if (view.getId() == btn_cancel.getId()) {
            // 清空输入框内容
            username.setText("");
            password.setText("");
        }
        // 点击注册按钮，进入注册界面，需要将注册的用户名返回到登录界面
        else if (view.getId() == btn_register.getId()) {

            // 直接进入注册界面
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//            startActivity(intent);
            // 用这种，可以携带参数
            startActivityForResult(intent, 100);
        }

    }

    /**
     * 重写onActivityResult，对注册界面传过来的intent进行处理
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            // 获取注册界面传来的intent对象中的数据
            loginUser = data.getStringExtra("username");
            loginPwd = data.getStringExtra("password");
            // 将用户名在文本框中显示
            username.setText(loginUser);
        }

    }

}