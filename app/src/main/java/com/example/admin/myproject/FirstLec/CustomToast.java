package com.example.admin.myproject.FirstLec;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class CustomToast extends AppCompatActivity {
    Button button1;
    View mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        button1 = (Button) findViewById(R.id.cut_btn);

       LayoutInflater layoutInflater = getLayoutInflater();
        mview = layoutInflater.inflate(R.layout.custom_toastlayout,(ViewGroup)findViewById(R.id.custom_layout));
    }

    public void customToastClick(View view) {
        Toast toast=Toast.makeText(this,"Toast:Gravity.TOP",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(mview);
        toast.show();
    }
}
