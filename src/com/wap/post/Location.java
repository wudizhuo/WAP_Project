package com.wap.post;

/**
 * Created by hongleyou on 2017/5/18.
 */
public class Location {
    private double longitude;
    private double latitude;

    public Location() {
    }

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
