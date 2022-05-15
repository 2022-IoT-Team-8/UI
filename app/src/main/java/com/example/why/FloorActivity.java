package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FloorActivity extends AppCompatActivity {
    FloorAdapter adapter = null;
    ArrayList<RoomData> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floor);

        item = new ArrayList<RoomData>();

        int floor = init();//floor 기반으로 강의실 셋팅

        //Adapter 셋팅
        ListView listView = findViewById(R.id.listView);
        adapter = new FloorAdapter(this, item);
        listView.setAdapter(adapter);

        //클릭 시 APActivity로 이동 (이동 시 몇호실인지 전달)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int roomnumber = floor * 100 + position + 1;
                Intent intent = new Intent(FloorActivity.this, APActivity.class);
                intent.putExtra("roomnumber", roomnumber);
                startActivity(intent);
            }
        });

    }

    public int init() {
        //몇 층인지 가져오기
        Intent intent = getIntent();
        int floor = intent.getIntExtra("floor", 0);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle(floor + "층");

        switch (floor) {
            case 2:
                for (int i = 201; i <= 230; i++)
                    item.add(new RoomData(2, i));
                break;

            case 4:
                for (int i = 401; i <= 434; i++)
                    item.add(new RoomData(4, i));
                break;

            case 5:
                for (int i = 501; i <= 532; i++)
                    item.add(new RoomData(5, i));
                break;

            default:
                break;

        }

        return floor;
    }
}
