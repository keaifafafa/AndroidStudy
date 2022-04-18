package com.example.dialogdemo01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn, btn2, btn3, btn4, btn5;
    TextView textView;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button7);
        textView = findViewById(R.id.textView);

        // 设置监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建一个Builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 设置对话框的各个组成部分
                builder.setTitle("退出系统")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("真的要退出吗？")
                        // 第一个参数是显示内容，第二个是事件监听器
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // 结束当前Activity
                                MainActivity.this.finish();
                            }
                        })
                        // 不用处理
                        .setNegativeButton("否", null)
                        .setCancelable(false);
                // 创建 AlertDialog 对象
                AlertDialog alertDialog = builder.create();
                // 显示对话框
                alertDialog.show();
            }
        });

        // 普通按钮监听器
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个Builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 设置对话框的各个组成部分
                builder.setTitle("退出系统")
                        .setIcon(R.mipmap.ic_launcher)
                        // 设置列表内容
                        .setItems(new String[]{"中国", "英国", "美国"}, null)
                        // 第一个参数是显示内容，第二个是事件监听器
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // 结束当前Activity
//                                MainActivity.this.finish();
                            }
                        })
                        // 不用处理
                        .setNegativeButton("否", null)
                        .setCancelable(false);
                // 创建 AlertDialog 对象
                AlertDialog alertDialog = builder.create();
                // 显示对话框
                alertDialog.show();
            }
        });

        // 单选对话框
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个Builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 设置对话框的各个组成部分
                builder.setTitle("单选框")
                        .setIcon(R.mipmap.ic_launcher)
                        // 设置单选列表
                        .setSingleChoiceItems(new String[]{"红色", "蓝色", "绿色"}, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                position = which;
                            }
                        })
                        // 第一个参数是显示内容，第二个是事件监听器
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (position == 0) {
                                    textView.setTextColor(Color.RED);
                                } else if (position == 1) {
                                    textView.setTextColor(Color.BLUE);
                                } else if (position == 2) {
                                    textView.setTextColor(Color.GREEN);
                                }
                            }
                        })
                        // 不用处理
                        .setNegativeButton("否", null)
                        .setCancelable(false);
                // 创建 AlertDialog 对象
                AlertDialog alertDialog = builder.create();
                // 显示对话框
                alertDialog.show();
            }
        });

        // 多选对话框
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个Builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 设置对话框的各个组成部分
                builder.setTitle("复选框")
                        .setIcon(R.mipmap.ic_launcher)
                        // 设置单选列表
                        .setMultiChoiceItems(new String[]{"红色", "蓝色", "绿色"}, new boolean[]{true, false, true}, null)
                        // 第一个参数是显示内容，第二个是事件监听器
                        .setPositiveButton("是", null)
                        // 不用处理
                        .setNegativeButton("否", null)
                        .setCancelable(false);
                // 创建 AlertDialog 对象
                AlertDialog alertDialog = builder.create();
                // 显示对话框
                alertDialog.show();
            }
        });

        // 自定义对话框
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个Builder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 获取视图
                View view = getLayoutInflater().inflate(R.layout.login, null);
                // 获取按钮设置监听器
                Button btnLogin = view.findViewById(R.id.button5);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    }
                });
                // 设置对话框的各个组成部分
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("登录系统")
                        // 设置自定义视图
                        .setView(view);
                builder.create().show();
            }
        });

    }
}