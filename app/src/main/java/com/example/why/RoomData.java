package com.example.why;

public class RoomData {
    int floor;//몇층 (2F, 4F, 5F)
    int room;//몇호 (230, 434, 532)

    public RoomData(int floor, int room) {
        this.floor = floor;
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
