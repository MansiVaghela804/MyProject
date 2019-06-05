package com.example.admin.myproject.Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.myproject.R;

public class Second_Activity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv=(TextView)findViewById(R.id.text_view);

        Intent intent=getIntent();
        String value=intent.getStringExtra("name");
        tv.setText(value);
    }
}
