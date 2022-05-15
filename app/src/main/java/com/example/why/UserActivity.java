package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    Button check;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle("User");

        check = findViewById(R.id.check);
        text = findViewById(R.id.room);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: DB에서 data를 가져와서 셋팅

                text.setText("413호");
            }
        });

    }

}
