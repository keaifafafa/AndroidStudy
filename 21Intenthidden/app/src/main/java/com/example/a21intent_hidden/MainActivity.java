package com.example.a21intent_hidden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 隐式Intent 和 IntentFilter
 */
public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        /**
         * 显式跳转
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 显式的跳转目标组件
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        /**
         * 隐式跳转
         */
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 隐式的跳转目标组件
                Intent intent = new Intent();
                // 设置动作 这里使用的是自定义的
                intent.setAction("com.intent.cdpc.VIEW");
//                intent.setAction("Intent.ACTION_VIEW");
                // 设置数据
                intent.setData(Uri.parse("stp://home.jsj.cdpc:8081/soft/a01"));
//                intent.setData(Uri.parse("http://www.baidu.com"));
                // 设置类别
//                intent.addCategory();
                startActivity(intent);
            }
        });
        /**
         * 使用隐式方式调用打电话功能
         */
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 检测有无分配打电话的权限
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    // 隐式的跳转目标组件
                    Intent intent = new Intent();
                    // 设置动作 使用系统自带的
                    intent.setAction(Intent.ACTION_CALL);
                    // 设置数据
                    intent.setData(Uri.parse("tel:1008611"));
                    startActivity(intent);
                }
                // 请求权限
                else {
                    // 会出出现一个对话框，供用户选择
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            // 同意授权
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 隐式的跳转目标组件
                Intent intent = new Intent();
                // 设置动作 使用系统自带的
                intent.setAction(Intent.ACTION_CALL);
                // 设置数据
                intent.setData(Uri.parse("tel:1008611"));
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "无此权限", Toast.LENGTH_SHORT).show();
        }
    }
}