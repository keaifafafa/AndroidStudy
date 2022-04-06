package com.example.a11list01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static ListView lsv1;
    private static String[] cities;
    List<String> list = new ArrayList<String>();
    List<CharSequence> list2 = new ArrayList<CharSequence>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsv1 = findViewById(R.id.listview1);
        // 初始化列表
        initList();
        // 方式二：将string.xml里的文本赋值到cities的数组中，然后根据数组下标来显示相应信息
        cities = getResources().getStringArray(R.array.city);
        // 创建一个适配器对象
       /* ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        // 将适配器对象绑定到listview
        lsv1.setAdapter(adapter);*/
        // 处理事件
        /**
         * 列表元素被单击的监听器
         */
       /* lsv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 方式一：获取每行的数据根据下标
                String item = (String) adapterView.getItemAtPosition(i);
                // 输出信息
//                Toast.makeText(MainActivity.this, "Hello " + item, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, list.get(i), Toast.LENGTH_SHORT).show();

            }
        });*/

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        lsv1.setAdapter(myBaseAdapter);
        // 自己绑定事件，思路同上
    }

    /**
     * 初始化列表
     */
    void initList() {
        for (int i = 0; i < 21; i++) {
            list.add("第" + i + "行");
        }

        for (int i = 0; i < 21; i++) {
            list2.add("你好" + i);
        }
    }

    /**
     * 基于BaseAdapter的适配器
     * 定义一个适配器[内部类]
     */
    public class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list2.size();
        }

        @Override
        public Object getItem(int i) {
            return list2.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // 将布局文件变成一个View对象
            View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.itemlayout, viewGroup, false);
            // 要在view1中寻找
            TextView tv1 = view1.findViewById(R.id.textView);
            System.out.println(list2.size());
            // CharSequence 是字符序列的意思 【是一个接口】
            tv1.setText((CharSequence) getItem(i));
            return view1;
        }
    }

}