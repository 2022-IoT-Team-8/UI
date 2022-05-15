package com.example.why;

import java.util.Date;
import java.util.UUID;

public class APData {
    private String id = UUID.randomUUID().toString();
    private Date createdAt = new Date();
    private String bssid;//identifier
    private String description;
    private String ssid;
    private String mac_address;
    private double x;
    private double y;
    private int sequence;
    private double meanRss;//for RP (-50 to -100)
//    High quality: 90% ~= -55db
//    Medium quality: 50% ~= -75db
//    Low quality: 30% ~= -85db
//    Unusable quality: 8% ~= -96db

    public APData(String ssid, String mac_address) {
        this.ssid = ssid;
        this.mac_address = mac_address;
    }


    public APData(String id, Date createdAt, String bssid, String description, String ssid, String mac_address, double x, double y, int sequence, double meanRss) {
        this.id = id;
        this.createdAt = createdAt;
        this.bssid = bssid;
        this.description = description;
        this.ssid = ssid;
        this.mac_address = mac_address;
        this.x = x;
        this.y = y;
        this.sequence = sequence;
        this.meanRss = meanRss;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public double getMeanRss() {
        return meanRss;
    }

    public void setMeanRss(double meanRss) {
        this.meanRss = meanRss;
    }
}
