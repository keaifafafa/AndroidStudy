package com.example.a08imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Switch01 extends AppCompatActivity {
    Switch aSwitch;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch01);
        aSwitch = findViewById(R.id.switch1);
        imageView = findViewById(R.id.imageView1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    imageView.setImageResource(R.drawable.state1);
                } else {
                    imageView.setImageResource(R.drawable.state0);
                }
            }
        });

    }
}