package com.example.a12recyclerview01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 回收站视图
 */
public class MainActivity extends AppCompatActivity {
    List<Fruit> fruitList = new ArrayList<Fruit>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化集合
        initFruit();
        recyclerView = findViewById(R.id.recycler);
        // 布局管理器1：线性布局管理器
        /*LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);*/
        // 布局管理器2：网格布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        MyFruitAdapter myFruitAdapter = new MyFruitAdapter(fruitList);
        // 设置布局
        // recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        // 设置适配器
        recyclerView.setAdapter(myFruitAdapter);
    }

    /**
     * 初始化水果集合
     */
    public void initFruit() {
        fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
        fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
        fruitList.add(new Fruit("Cherry", R.drawable.cherry_pic));
        fruitList.add(new Fruit("Grape", R.drawable.grape_pic));
        fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
        fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
        fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
        fruitList.add(new Fruit("Pineapple", R.drawable.pineapple_pic));
        fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
    }
}