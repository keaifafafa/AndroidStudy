package com.example.a20notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    NotificationManager notificationManager;
    String CHANNEL = "ch01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        // 获取系统服务
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 版本号大于等于 安卓8
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // 创建通道
                    NotificationChannel channel = new NotificationChannel(CHANNEL, "hello", NotificationManager.IMPORTANCE_HIGH);
                    // 设置通道特征
                    channel.enableLights(true);
                    channel.enableVibration(true);
                    channel.setLightColor(Color.RED);
                    channel.setVibrationPattern(new long[]{0, 1000, 2000, 3000});
                    // 高版本才需要，低版本不需要
                    notificationManager.createNotificationChannel(channel);
                }
                // 创建构造器
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL);
                // 设置标题
                builder.setContentTitle("通知标题")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("今天下午开会")
                        .setWhen(System.currentTimeMillis());
                // TODO 设置大图标
//                .setLargeIcon(R.drawable.p2)
                // 显示
                Notification build = builder.build();
                notificationManager.notify(1, build);
            }
        });
    }
}