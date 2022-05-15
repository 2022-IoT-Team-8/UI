package com.example.why;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class SearchAPActivity extends AppCompatActivity {
    private WifiManager wifiManager;
    private int size=0;
    private List<ScanResult> results;
    private ArrayList<APData> item = new ArrayList<>();
    private SearchAPAdapter adapter = null;
    private ListView listview;
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_wifis);

        init();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if(!wifiManager.isWifiEnabled()){
            Toast.makeText(this, "WiFi is disabled ... We need to enable it", Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        adapter = new SearchAPAdapter(this, item);
        listview.setAdapter(adapter);

        scanWifi();

    }

    public void init(){
        refresh = findViewById(R.id.refresh);
        listview = findViewById(R.id.listView);

        //Action Bar 수정
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Search WiFi");

        //refresh 버튼이 눌리면 WiFi 검색
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanWifi();
            }
        });

    }

    private void scanWifi(){
        item.clear();
        registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if(wifiManager.startScan())
            Toast.makeText(this, "Scanning WiFi ...", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "failed to Scanning WiFi ...", Toast.LENGTH_SHORT).show();
    }

    BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            results = wifiManager.getScanResults();
            unregisterReceiver(this);

            for (ScanResult scanResult : results) {
                item.add(new APData(scanResult.SSID, scanResult.BSSID));//SSID, MAC Number 추가
                adapter.notifyDataSetChanged();
            }
        };
    };

}
