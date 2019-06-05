package com.example.admin.myproject.SharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class Data_store_activity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_store_layout);
        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);

    }

    public void save(View view) {

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Key1",username.getText().toString());
        editor.putString("Key2",password.getText().toString());

        editor.commit();

        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();

        }

    public void next(View view) {
        Intent i = new Intent(Data_store_activity.this, LoadActivity.class);
        startActivity(i);
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();

    }
}
