package com.example.a05buttons;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    RadioGroup rg1;
    RadioButton rb1, rb2, rb3;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg1 = findViewById(R.id.radioGroup2);
        rb1 = findViewById(R.id.radioButton5);
        rb2 = findViewById(R.id.radioButton6);
        rb3 = findViewById(R.id.radioButton7);
        tv1 = findViewById(R.id.textView);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton5) {
                    tv1.setText("hello001");
                }
                if (i == R.id.radioButton6) {
                    tv1.setText("hello002");
                }
                if (i == R.id.radioButton7) {
                    tv1.setText("hello003");
                }
            }
        });
    }
}