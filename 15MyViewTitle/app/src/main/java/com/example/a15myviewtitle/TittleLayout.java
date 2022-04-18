package com.example.a15myviewtitle;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TittleLayout extends LinearLayout {
    public TittleLayout(Context context) {
        super(context);
    }

    /**
     * 在布局文件中添加该组合控件，该构造方法一定要重写
     *
     * @param context
     * @param attrs
     */
    public TittleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        TextView tx = findViewById(R.id.textView);
        tx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tx.setTextColor(Color.RED);
            }
        });
    }

    public TittleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TittleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
