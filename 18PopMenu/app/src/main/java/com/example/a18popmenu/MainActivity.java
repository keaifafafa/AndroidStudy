package com.example.a18popmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button shareBtn, showFloatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareBtn = findViewById(R.id.share);
        showFloatBtn = findViewById(R.id.show_float);

        // 给分享按钮添加监听事件
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1、创建弹出菜单对象
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, shareBtn);
                // 2、将菜单资源文件变成 popupMenu 中的menu对象
                getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                // 3、对弹出式菜单项进行弹出处理
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.wechat) {
                            Toast.makeText(MainActivity.this, "成功分享至微信", Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId() == R.id.micro_blog) {
                            Toast.makeText(MainActivity.this, "成功分享至微博", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                // 4、显示
                popupMenu.show();
            }
        });

        // 给显示悬浮框按钮添加监听事件
        showFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1、获取视图，将xml转为视图
                View view1 = getLayoutInflater().inflate(R.layout.layout01, null, false);
                // 2、创建悬浮框
                PopupWindow popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                // 设置动画效果
                popupWindow.setAnimationStyle(R.style.popanimation);
                // 3、显示悬浮框，并指定位置
                // 参数一是参考位置，参数二为左偏移量，第三个是有右偏移量
                popupWindow.showAsDropDown(showFloatBtn, 80, 80);
                // 4、设置对应的事件
                Button closeFloat = view1.findViewById(R.id.close_float);
                closeFloat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "成功关闭悬浮窗", Toast.LENGTH_SHORT).show();
                        // 5、关闭悬浮窗
                        popupWindow.dismiss();
                    }
                });

                /*// 跳转视图
                Intent intent = new Intent(MainActivity.this, FloatingWindow.class);
                startActivity(intent);*/
            }
        });

        //
    }
}