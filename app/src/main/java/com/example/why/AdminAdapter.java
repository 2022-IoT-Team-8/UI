package com.example.why;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdminAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<FloorData> item;

    public AdminAdapter(Context mContext, ArrayList<FloorData> item) {
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
    public FloorData getItem(int position) {
        return item.get(position);
    }


    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.item_layout, null);

        TextView Floor = view.findViewById(R.id.Floor);
        TextView Room = view.findViewById(R.id.Room);

        String setFloorText = Integer.toString(item.get(position).getFloor()) + "F";
        String setRoomRangeText = Integer.toString(item.get(position).getFloor()) + "01호 ~ " + Integer.toString(item.get(position).getMaxroom()) + "호";

        Floor.setText(setFloorText);
        Room.setText(setRoomRangeText);

        return view;
    }

}
