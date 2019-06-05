package com.example.admin.myproject.FirstLec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class FirstActivity extends AppCompatActivity {
    EditText username;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);

        username=(EditText)findViewById(R.id.edt);
        btn=(Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String data=username.getText().toString();

               Toast.makeText(FirstActivity.this,data, Toast.LENGTH_SHORT).show();
                }
        });

    }
}
