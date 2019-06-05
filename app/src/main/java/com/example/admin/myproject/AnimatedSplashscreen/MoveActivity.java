package com.example.admin.myproject.AnimatedSplashscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.admin.myproject.R;

public class MoveActivity extends AppCompatActivity {
    Animation animation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        imageView=(ImageView)findViewById(R.id.move_anim);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);
        imageView.startAnimation(animation);

    }
}
