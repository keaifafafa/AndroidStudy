package com.example.a15divview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 自定义组件
 */
public class MyCircle extends View {
    // 半径
    private int radius;
    // 填充色
    private int fillColor;
    // 圆心初始坐标
    private float x = 100, y = 100;

    public MyCircle(Context context) {
        super(context);
    }

    /**
     * 在布局文件中添加控件，必须要有如下构造方法
     *
     * @param context
     * @param attrs
     */
    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircle);
        if (null != typedArray) {
            // 读取的是 attr.xml里的名称
            radius = typedArray.getInt(R.styleable.MyCircle_radius, 10);
            fillColor = typedArray.getColor(R.styleable.MyCircle_fillColor, Color.RED);
            // 释放资源
            typedArray.recycle();
        }
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 对触碰事件进行处理，拖动小球
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }

    /**
     * 设置控件的外观
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画布颜色
        canvas.drawColor(Color.GREEN);
        Paint paint = new Paint();
        // 设置画笔颜色
        paint.setColor(fillColor);
        // 第一个参数: 圆心横坐标， 第二个：圆心纵坐标， 第三个：半径， 第四个: 画笔
        canvas.drawCircle(x, y, radius, paint);
    }

    /**
     * 设置控件大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(400, 500);
    }
}
