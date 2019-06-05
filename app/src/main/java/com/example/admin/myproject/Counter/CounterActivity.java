package com.example.admin.myproject.Counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.myproject.R;

public class CounterActivity extends AppCompatActivity {
    Button count_plus,count_minus;
    ImageView imageView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        imageView=(ImageView)findViewById(R.id.cup_cake);
        count_plus=(Button)findViewById(R.id.btn_count);
        count_minus=(Button)findViewById(R.id.btn_count2);
    }
}
