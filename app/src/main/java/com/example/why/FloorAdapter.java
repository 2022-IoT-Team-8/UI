package com.example.why;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class FloorAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<RoomData> item;

    public FloorAdapter(Context mContext, ArrayList<RoomData> item) {
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
    public RoomData getItem(int position) {
        return item.get(position);
    }


    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.item_layout, null);

        TextView Floor = view.findViewById(R.id.Floor);
        TextView Room = view.findViewById(R.id.Room);

        String setFloorText = Integer.toString(item.get(position).getFloor()) + "F";
        String setRoomText = Integer.toString(item.get(position).getRoom()) + "호";

        Floor.setText(setFloorText);
        Room.setText(setRoomText);

        return view;
    }


}
