package com.example.a10spinner01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spColor, spSize;
    TextView textView;
    String[] fontSize = {"小号字", "中号字", "大号字"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spColor = findViewById(R.id.spinner);
        spSize = findViewById(R.id.spinner2);
        textView = findViewById(R.id.textView);
        /** 将颜色列表转为java数组 **/
        String[] stringArray = getResources().getStringArray(R.array.font_color);

        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             *
             * @param adapterView
             * @param view
             * @param i 第几个按钮，位置
             * @param l
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    textView.setTextColor(Color.RED);
                }
                if (i == 1) {
                    textView.setTextColor(Color.BLUE);
                }
                if (i == 2) {
                    textView.setTextColor(Color.GREEN);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /**
         * 适配器方式二
         */
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.id.sp, fontSize);
    }
}