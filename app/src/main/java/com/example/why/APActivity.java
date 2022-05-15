package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class APActivity extends AppCompatActivity {
    APAdapter adapter= null;
    ArrayList<APData> item;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ap);

        item = new ArrayList<APData>();
        add_button = findViewById(R.id.add);

        int roomnumber = init();//floor 기반으로 강의실 셋팅

        //Adapter 셋팅
        ListView listView = findViewById(R.id.listView);
        adapter = new APAdapter(this, item);
        listView.setAdapter(adapter);

        //ADD button이 눌렸을 때
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APActivity.this, AddOrEditAPActivity.class);
                intent.putExtra("roomnumber", roomnumber);
                startActivity(intent);
            }
        });

        //Todo: 기존에 저장된 data를 수정하길 원하는 경우, ADDOREditAPActivity에 SSID와 MAC 전달

    }

    public int init() {
        //조사 할 강의실이 어딘지 가져오기
        Intent intent = getIntent();
        int roomnumber = intent.getIntExtra("roomnumber", 0);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle(roomnumber + "호");

        //Todo: DB에서 해당 강의실에서 조사된 Data를 가져와 셋팅하기, 완성되면 dummy data 지울 것

        //dummy data 추가 (for test)
        item.add(new APData("dummy data1", "AB:CD:EF:GH:IJ:KL"));
        item.add(new APData("dummy data2", "MN:OP:QR:ST:UV:WX"));
        item.add(new APData("dummy data3", "YZ:AB:CD:EF:GH:IJ"));


        return roomnumber;
    }

}
