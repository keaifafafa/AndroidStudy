package com.example.a11listview02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化BaseAdapter
 */
public class MainActivity extends AppCompatActivity {
    List<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化列表
        initList();
        // 生成 MyBaseAdapter
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, userList);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(myBaseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.LENGTH_SHORT：持续时间
                Toast.makeText(MainActivity.this, userList.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * 初始化列表
     */
    void initList() {
        User user1 = new User("张三", R.drawable.pic0);
        userList.add(user1);
        User user2 = new User("李四", R.drawable.pic1);
        userList.add(user2);
        User user3 = new User("王五", R.drawable.pic2);
        userList.add(user3);
        User user4 = new User("刘奇", R.drawable.pic3);
        userList.add(user4);
        User user5 = new User("赵涛", R.drawable.pic4);
        userList.add(user5);
        User user6 = new User("宋江", R.drawable.pic5);
        userList.add(user6);
        User user7 = new User("鲁智深", R.drawable.pic6);
        userList.add(user7);
        User user8 = new User("李逵", R.drawable.pic7);
        userList.add(user8);
        User user9 = new User("赵云", R.drawable.pic8);
        userList.add(user9);
        User user10 = new User("吕布", R.drawable.pic9);
        userList.add(user10);
        User user11 = new User("张飞", R.drawable.pic11);
        userList.add(user11);
        User user12 = new User("关羽", R.drawable.pic12);
        userList.add(user12);
    }

}