package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {
    TextView text;
    int time_out = 2800;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        text = (TextView) findViewById(R.id.text1);

        //Action Bar 제거
        ActionBar bar = getSupportActionBar();
        bar.hide();

        //animation 추가
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.intro_anim);
        text.startAnimation(anim);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time_out);

    }

}
