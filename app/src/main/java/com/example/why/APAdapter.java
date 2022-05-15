package com.example.why;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class APAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<APData> item;

    public APAdapter(Context mContext, ArrayList<APData> item) {
        this.mContext = mContext;
        this.item = item;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() { return item.size(); }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public APData getItem(int position) {
        return item.get(position);
    }


    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.ap_layout, null);

        TextView SSID = view.findViewById(R.id.SSID);
        TextView MACnumber = view.findViewById(R.id.MAC);

        SSID.setText(item.get(position).getSSID());
        MACnumber.setText(item.get(position).getMACnumber());

        return view;
    }

}
