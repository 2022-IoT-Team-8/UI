package com.example.why;

public class FloorData {
    int floor;//몇층 (2F, 4F, 5F)
    int maxroom;// 최대 몇호까지 있는지 (230, 434, 532)

    public FloorData(int floor, int maxroom) {
        this.floor = floor;
        this.maxroom = maxroom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxroom() {
        return maxroom;
    }

    public void setMaxroom(int maxroom) {
        this.maxroom = maxroom;
    }
}
