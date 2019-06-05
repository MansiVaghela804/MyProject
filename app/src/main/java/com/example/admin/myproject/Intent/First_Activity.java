package com.example.admin.myproject.Intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.myproject.R;

public class First_Activity extends AppCompatActivity {
    EditText username;
    Button btn;
    String url="https://www.javatpoint.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        username = (EditText) findViewById(R.id.user_name);
        btn = (Button) findViewById(R.id.save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = username.getText().toString();
//                    data.isEmpty

                if (data.length()==0) {
                    username.setError("Please enter this filed");
                } else {
                    Intent intent = new Intent(First_Activity.this, Second_Activity.class);
                    intent.putExtra("name", data);
                    startActivity(intent);
                }
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);

            }
        });
    }
}
