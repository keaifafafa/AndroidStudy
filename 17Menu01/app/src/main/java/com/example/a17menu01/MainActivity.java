package com.example.a17menu01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.layout);
        textView = findViewById(R.id.textView);
        // 注册到文本菜单 也就是将其与文本菜单进行绑定
        registerForContextMenu(textView);
    }

    /**
     * 重写 onCreateOptionsMenu 方法
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 选项菜单监听
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bg_menu1:
                constraintLayout.setBackgroundResource(R.drawable.bj1);
                break;
            case R.id.bg_menu2:
                constraintLayout.setBackgroundResource(R.drawable.bj2);
                break;
            case R.id.bg_menu3:
                constraintLayout.setBackgroundResource(R.drawable.bj3);
                break;
            case R.id.bg_menu4:
                constraintLayout.setBackgroundResource(R.drawable.bj4);
                break;
            case R.id.text_red:
                textView.setTextColor(Color.RED);
                break;
            case R.id.text_blue:
                textView.setTextColor(Color.BLUE);
                break;
            case R.id.text_yellow:
                textView.setTextColor(Color.YELLOW);
                break;
            case R.id.text_green:
                textView.setTextColor(Color.GREEN);
                break;
            case R.id.exit_menu:
                MainActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 虽然上下文菜单只能显示一个，但是可以定义多个
        // 如果是一个按钮，则设置为上下文菜单
        // 如果不是，这设置另外一个是上下文菜单
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    /**
     * 对点击事件进行处理
     *
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.size_small) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        } else if (item.getItemId() == R.id.size_medium) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (item.getItemId() == R.id.size_big) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }
        return super.onContextItemSelected(item);
    }
}