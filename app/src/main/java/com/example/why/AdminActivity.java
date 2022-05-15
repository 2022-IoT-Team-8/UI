package com.example.why;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    AdminAdapter adapter= null;
    ArrayList<FloorData> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        item = new ArrayList<FloorData>();

        //2F, 4F, 5F에 존재하는 가장 높은 호실 추가
        item.add(new FloorData(2, 230));
        item.add(new FloorData(4, 434));
        item.add(new FloorData(5, 532));

        //Adapter 셋팅
        ListView listView = findViewById(R.id.listView);
        adapter = new AdminAdapter(this, item);
        listView.setAdapter(adapter);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Admin");

        //클릭 시 FloorActivity로 이동 (이동 시 몇 층인지 전달)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(AdminActivity.this, FloorActivity.class);

                switch (position){
                    case 0:
                        intent.putExtra("floor", 2);//2층이 눌렸다고 넘기기
                        startActivity(intent);
                        break;

                    case 1:
                        intent.putExtra("floor", 4);//4층이 눌렸다고 넘기기
                        startActivity(intent);
                        break;

                    case 2:
                        intent.putExtra("floor", 5);//5층이 눌렸다고 넘기기
                        startActivity(intent);
                        break;

                    default:
                        break;
                }

            }
        });

    }
}
