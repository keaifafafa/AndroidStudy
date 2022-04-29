package com.example.a20notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    Button btn, btn2, btn3;
    NotificationManager notificationManager;
    String CHANNEL = "ch01";
    int notify_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        // 获取系统服务
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 发送通知
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 版本号大于等于 安卓8 注意最后是大写的 o
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // 创建通道
                    NotificationChannel channel = new NotificationChannel(CHANNEL, "通知", NotificationManager.IMPORTANCE_HIGH);
                    // 设置通道特征
                    channel.enableLights(true);
                    channel.enableVibration(true);
                    channel.setLightColor(Color.RED);
                    // 间隔震动时间
                    channel.setVibrationPattern(new long[]{0, 1000, 2000, 3000});
                    // 高版本才需要，低版本不需要
                    notificationManager.createNotificationChannel(channel);
                }
                // 设置跳转的视图
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                PendingIntent activity = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                // 创建构造器对象
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL);
                // 设置标题
                builder
                        .setContentTitle("重要会议")
                        .setContentText("今天下午3:00在人民大会堂召开全体职工表彰大会，不得缺席！！！")
                        // 这个不一定会显示
                        .setTicker("你有一条通知")
                        // 设置时间戳
                        .setWhen(System.currentTimeMillis())
                        // 设置小图标
                        .setSmallIcon(R.drawable.a3)
                        // 设置大图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.a4))
                        // 设置点击通知后跳转的视图
                        .setContentIntent(activity)
                        // 自动消失【点击通知后】
                        .setAutoCancel(true)
                        // 设置长文本 【会取代原来的设置的普通文本内容】
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("《魁拔》是2008年北京青青树动漫科技有限公司以系列动画电影的第一部" +
                                "《魁拔之十万火急》为基础，" + "重新剪辑而成的TV动画。由王川执导，田博、马华等编剧，刘婧荦，竹内顺子等配音。\n" +
                                "TV版完整保留了电影的世界观、人物设定、故事内容和情节主线，但重制了片头曲。《魁拔妖侠传》是魁拔系列电影的前传，" +
                                "主要讲述的是有关卡拉肖克潘家族的故事，与电影关系并不大。大家所说的魁拔通常指魁拔系列动画电影。"))
                        // 设置大图片 注意bigPicture需要的是 Bitmap 对象
                        // 所以需要借助 BitmapFactory 将 图片资源变成 Bitmap资源
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.a1)));
                // 创建 Notification 对象
                Notification build = builder.build();
                // 显示通知 id就是这个通知的唯一编号，后面取消会用到
                notify_id = 100;
                notificationManager.notify(notify_id, build);
            }
        });

        // 取消通知
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(notify_id);
            }
        });

        // 发送自定义通知
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 版本号大于等于 安卓8 注意最后是大写的 o
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // 创建通道
                    NotificationChannel channel = new NotificationChannel(CHANNEL, "通知", NotificationManager.IMPORTANCE_HIGH);
                    // 设置通道特征
                    channel.enableLights(true);
                    channel.enableVibration(true);
                    channel.setLightColor(Color.RED);
                    // 间隔震动时间
                    channel.setVibrationPattern(new long[]{0, 1000, 2000, 3000});
                    // 高版本才需要，低版本不需要
                    notificationManager.createNotificationChannel(channel);
                }
                // 设置跳转的视图
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                PendingIntent activity = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                // 将布局文件变成 remoteView对象
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout01);
                // 注意设置相关属性不然无法显示
                remoteViews.setImageViewResource(R.id.imageView3, R.drawable.a3);
                remoteViews.setTextViewText(R.id.textView3, "hello");
                // 创建构造器对象
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL);
                // 设置标题
                builder.setContentTitle("重要会议")
                        .setContentText("今天下午3:00在人民大会堂召开全体职工表彰大会，不得缺席！！！")
                        // 设置小图标
                        .setSmallIcon(R.drawable.a3)
                        // 设置自定义视图
                        .setCustomContentView(remoteViews)
                ;
                // 创建 Notification 对象
                Notification build = builder.build();
                // 显示通知 id就是这个通知的唯一编号，后面取消会用到
                notify_id = 100;
                notificationManager.notify(notify_id, build);
            }
        });


    }
}