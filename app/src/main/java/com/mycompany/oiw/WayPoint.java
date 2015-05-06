package com.mycompany.oiw;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Sony on 3/30/2015.
 */
public class WayPoint implements Parcelable{
    private LatLng coordinate;
    private String title;

    public LatLng getCoordinate() {
        return coordinate;
    }

    public String getTitle() {
        return title;
    }

    public void setCoordinate(LatLng coordinate) {
        this.coordinate = coordinate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WayPoint(LatLng coordinate, String title) {
        this.coordinate = coordinate;
        this.title = title;
    }

    private WayPoint(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
