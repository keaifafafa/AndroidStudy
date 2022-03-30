package com.example.a06checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Button btn1;
    CheckBox cb1, cb2, cb3, cb4, cbBold, cbItalic;
    TextView textView1;
    /**
     * 存放爱好的集合
     */
    List<String> hobbies = new ArrayList<>();
    /**
     * 用于判断的变量
     */
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cbBold = findViewById(R.id.checkBox5);
        cbItalic = findViewById(R.id.checkBox6);
        textView1 = findViewById(R.id.textView);

        // 绑定监听器
        cb1.setOnCheckedChangeListener(this::onCheckedChanged);
        cb2.setOnCheckedChangeListener(this::onCheckedChanged);
        cb3.setOnCheckedChangeListener(this::onCheckedChanged);
        cb4.setOnCheckedChangeListener(this::onCheckedChanged);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hobbies.size() > 0) {
                    textView1.setText("您选择的爱好是" + hobbies.toString());
                } else {
                    textView1.setText("您未选择任何爱好");
                }
            }
        });

        /**
         * 修改 加粗和倾斜不兼容的问题
         * 思路:很简单
         * 1、如果加粗按钮被选中，则会进行判断，如果斜体也被选中，则会既加粗又倾斜，否则，只进行加粗
         * 2、如果加粗没被选中，也会判断倾斜又没有被选中，有的话就会倾斜，没有的话就会变成无任何状态。
         */
        cbBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (cbItalic.isChecked()) {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC);
                    } else {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                    }
                } else {
                    if (cbItalic.isChecked()) {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                    } else {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                    }
                }
            }
        });

        /**
         * 字体倾斜事件绑定
         * 思路同上
         */
        cbItalic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (cbBold.isChecked()) {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC);
                    } else {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                    }
                } else {
                    if (cbBold.isChecked()) {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                    } else {
                        textView1.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                    }
                }
            }
        });

    }

    /**
     * 实现接口
     *
     * @param compoundButton
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        String str = compoundButton.getText().toString();
        if (isChecked) {
            // 存到集合中
            hobbies.add(str.trim());
        } else {
            // 移除对象
            hobbies.remove(str.trim());
        }
    }
}