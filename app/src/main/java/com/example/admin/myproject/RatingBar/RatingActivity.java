package com.example.admin.myproject.RatingBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class RatingActivity extends AppCompatActivity {
    RatingBar ratingbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.Submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rating=String.valueOf(ratingbar.getRating());

                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();

            }
        });

    }
}
