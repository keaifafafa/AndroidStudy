package com.example.a11listview02;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    List<User> userList;

    /**
     * Context是维持Android程序中各组件能够正常工作的一个核心功能类。
     * 这也是Android 区分 普通Java开发的一大特点
     */
    Context mContext;

    public MyBaseAdapter(Context mContext, List<User> userList) {
        this.userList = userList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 注意每次完成的是一行的内容
     *
     * @param i         表示当前绘制的item的下标
     * @param view      表示可复用的view对象
     * @param viewGroup 表示当前绘制的item所属的listView控件
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        /**
         * 未优化版本
         * 缺点是会造成的性能的浪费，因为有的对象已经存在了，会进行重复创建
         */
       /* // 将布局文件变成一个View对象 这里就用到了上下文对象
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.userlayout, viewGroup, false);
        // 要在view1中寻找
        TextView tv1 = view1.findViewById(R.id.textView);
        ImageView iv1 = view1.findViewById(R.id.imageView);
        // 设置内容
        tv1.setText(userList.get(i).getName());
        iv1.setImageResource(userList.get(i).getImagePathId());
        Log.i("TAG", i + "");
        return view1;*/

        /**
         * 小优化，提升查询性能，使用缓存
         * 思路：
         * 1、就是第一页是没有对象的，所以需要创建
         * 2、但是第二页完全可以利用第一创建的对象空间啊【这样就节约了不必要的资源浪费】
         */
        /*View view1;
        // 缓存为空
        if (view == null) {
            view1 = LayoutInflater.from(mContext).inflate(R.layout.userlayout, viewGroup, false);
        } else {
            // 从缓存中查找
            view1 = view;
        }
        // 要在view1中寻找
        TextView tv1 = view1.findViewById(R.id.textView);
        ImageView iv1 = view1.findViewById(R.id.imageView);
        // 设置内容
        tv1.setText(userList.get(i).getName());
        iv1.setImageResource(userList.get(i).getImagePathId());
        Log.i("TAG", i + "");
        return view1;*/

        /**
         * 进一步优化：ViewHolder
         * 优化点在于不用每次都去创建TextView 和 ImageView 对象了
         */
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.userlayout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.textView);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(userList.get(i).getName());
        viewHolder.imageView.setImageResource(userList.get(i).getImagePathId());
        //  单击名字，变红色
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.textView.setTextColor(Color.RED);
            }
        });
        return view;
    }

    public final class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }
}
