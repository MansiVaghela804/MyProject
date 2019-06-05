package com.example.admin.myproject.SharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class LoadActivity extends AppCompatActivity {
    TextView name, password;
    public static final String Default = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        name = (TextView) findViewById(R.id.user_text);
        password = (TextView) findViewById(R.id.pass_text);

    }

    public void Load(View view) {

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        String Text1=sharedpreferences.getString("Key1",Default);
        String Text2=sharedpreferences.getString("Key2",Default);

        if (name.equals(Default) || password.equals(Default)) {
            Toast.makeText(this, "No data was found", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Data Loaded sucessfully", Toast.LENGTH_SHORT).show();
            name.setText(Text1);
            password.setText(Text2);
        }

    }

    public void Previous(View view) {

        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Data_store_activity.class);
        startActivity(i);

    }
}
