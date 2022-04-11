package com.example.a12gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemInfo> list = new ArrayList<ItemInfo>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        // 得到这个控件
        gridView = findViewById(R.id.gridview);
        // 设置监听器
        gridView.setAdapter(new MyGridAdapter());
        // 设置事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, ShowView01.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     * 初始化数据
     */
    public void initData() {
        list.add(new ItemInfo("通讯录", R.drawable.address_book));
        list.add(new ItemInfo("日历", R.drawable.calendar));
        list.add(new ItemInfo("照相机", R.drawable.camera));
        list.add(new ItemInfo("时钟", R.drawable.clock));
        list.add(new ItemInfo("游戏", R.drawable.games_control));
        list.add(new ItemInfo("联系人", R.drawable.messenger));
        list.add(new ItemInfo("铃声", R.drawable.ringtone));
        list.add(new ItemInfo("设置", R.drawable.settings));
        list.add(new ItemInfo("信息", R.drawable.speech_balloon));
        list.add(new ItemInfo("天气", R.drawable.weather));
        list.add(new ItemInfo("浏览器", R.drawable.world));
        list.add(new ItemInfo("视频", R.drawable.youtube));
    }

    /**
     * 定义内部类，适配器类
     */
    class MyGridAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            // 查看缓存中是否存在
            if (convertView == null) {
                 /*
                 第一个参数：需要加载布局文件的id，意思是需要将这个布局文件中加载到Activity中来操作，
                 第二个：需要附加到resource资源文件的根控件，什么意思呢，就是inflate()会返回一个View对象，
                        如果第三个参数attachToRoot为true，就将这个root作为根对象返回，
                        否则仅仅将这个root对象的LayoutParams属性附加到resource对象的根布局对象上，
                        也就是布局文件resource的最外层的View上，比如是一个LinearLayout或者其它的Layout对象
                 第三个：是否将root附加到布局文件的根视图上
                 */
                convertView = getLayoutInflater().inflate(R.layout.itemlayout, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.textView);
                viewHolder.imageView = convertView.findViewById(R.id.imageView);
                convertView.setTag(viewHolder);
            } else {
                // 获取缓存信息，注意转型
                viewHolder = (ViewHolder) convertView.getTag();
            }
            // 对单个按钮设置事件（更细的颗粒度）,主要是区分上面设置的 GridView 的监听器
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.textView.setBackgroundColor(Color.RED);
                }
            });
            viewHolder.textView.setText(list.get(position).getName());
            viewHolder.imageView.setImageResource(list.get(position).getImgId());
            return convertView;
        }
    }
}

/**
 * 定义适配器类
 */
class ViewHolder {
    TextView textView;
    ImageView imageView;
}
