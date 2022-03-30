package com.example.a08imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        /**
         *
         */
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton) {
                    imageView.setImageResource(R.drawable.state1);
                }
                if (i == R.id.radioButton2) {
                    imageView.setImageResource(R.drawable.state0);
                }
            }
        });
    }
}