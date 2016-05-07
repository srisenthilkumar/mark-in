package com.markin.app.monitor.model;

/**
 * Created by salagumalai on 17-04-2016.
 */
public class DeviceLocation {

    private String UserName;
    private double Latitude;
    private double Longitude;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
