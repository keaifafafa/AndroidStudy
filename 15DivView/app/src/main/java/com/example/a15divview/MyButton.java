package com.example.a15divview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

/**
 * 自定义按钮
 */
@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    /**
     * 设置为圆角，填充色为红色，字号为30sp
     *
     * @param context
     * @param attrs
     */
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        setText("Click");
        setBackground(getResources().getDrawable(R.drawable.btnstyle));

    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
