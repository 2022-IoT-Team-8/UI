package com.example.why;

public class APData {
    String SSID;
    String MACnumber;
    // float distance; 측정한 위치에서 얼마만큼 떨어져 있는가
    // int room; 측정한 위치
    // float X;
    // float Y;


    public APData(String SSID, String MACnumber) {
        this.SSID = SSID;
        this.MACnumber = MACnumber;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getMACnumber() {
        return MACnumber;
    }

    public void setMACnumber(String MACnumber) {
        this.MACnumber = MACnumber;
    }
}
