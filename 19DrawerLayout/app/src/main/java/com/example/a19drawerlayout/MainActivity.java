package com.example.a19drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] textColor = new String[]{"红色", "黄色", "绿色"};
    private ListView listView;
    private TextView textView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        textView = findViewById(R.id.textView);
        drawerLayout = findViewById(R.id.drawer);
        // 关联适配器
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_single_choice, textColor);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    textView.setTextColor(Color.RED);
                    textView.setText("北京");
                } else if (i == 1) {
                    textView.setTextColor(Color.YELLOW);
                    textView.setText("上海");
                } else if (i == 2) {
                    textView.setTextColor(Color.GREEN);
                    textView.setText("天津");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu01, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 处理菜单下的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.show) {
            // 从右至左显示
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}