package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddOrEditAPActivity extends AppCompatActivity {
    Button scan, create;
    Intent intent;
    int roomnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ap);

        scan = findViewById(R.id.scan);
        create = findViewById(R.id.create);

        //받아 온 강의실 저장하기
        intent = getIntent();
        roomnumber = intent.getIntExtra("roomnumber", 0);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle(roomnumber + "호 AP 추가하기");

        //scan button 눌렀을 때
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddOrEditAPActivity.this, SearchAPActivity.class);
                startActivity(intent);
            }
        });

        //create button 눌렀을 때
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: DB에 저장하기

                Intent intent = new Intent(AddOrEditAPActivity.this, APActivity.class);
                intent.putExtra("roomnumber", roomnumber);
                startActivity(intent);
            }
        });

    }

}
