package com.example.a12recyclerview01;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义适配器类
 */
public class MyFruitAdapter extends RecyclerView.Adapter<MyFruitAdapter.MyViewHold> {

    private List<Fruit> fruitList;

    /**
     * 构造方法，初始化参数
     *
     * @param fruitList
     */
    public MyFruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    /**
     * 静态内部类
     * 注意一定要写构造方法
     */
    static class MyViewHold extends RecyclerView.ViewHolder {
        TextView fTextView;
        ImageView fImageView;
        TextView price;

        public MyViewHold(@NonNull View itemView) {
            super(itemView);
            // 注意转型
            fTextView = (TextView) itemView.findViewById(R.id.textView);
            price = (TextView) itemView.findViewById(R.id.textView2);
            fImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlayout, parent, false);
        MyViewHold viewHold = new MyViewHold(view);
        return viewHold;
    }

    /**
     * 绑定
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, int position) {
        holder.fTextView.setText(fruitList.get(position).getFruitName());
        holder.fImageView.setImageResource(fruitList.get(position).getFruitImageId());
        holder.price.setText("价格：" + fruitList.get(position).getPrice() + "元");
        // 深黄色
        holder.price.setTextColor(Color.rgb(128, 128, 0));


    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }


}
