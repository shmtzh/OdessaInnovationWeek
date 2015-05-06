package com.mycompany.oiw;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class CustomMapFragment extends Fragment {

    private static final String POINTS = "POINTS";
    private static final String POINT = "POINT";
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private MapFragment mapFragment;
   // public  LatLngBounds HUB = new LatLngBounds(new LatLng(46.481812, 30.746008), new LatLng(46.481744, 30.748555));





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        setUpMapIfNeeded();
        return view;
    }


//    @Override
//    public void onResume() {
//            myMapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
//            myMap = myMapFragment.getMap();

//        if (getArguments().containsKey(POINT)) {
//            WayPoint point = getArguments().getParcelable(POINT);
//            updateMap(point);
//        } else {
//           throw new ArrayIndexOutOfBoundsException ("dd") ;
//

    private void updateMap(WayPoint point) {
        if (mMap != null) {
            mMap.clear();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            BitmapDescriptor defaultMarker =
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
            mMap.addMarker(new MarkerOptions()
                    .position(point.getCoordinate())
                    .title(point.getTitle())
                    .icon(defaultMarker));
            builder.include(point.getCoordinate());
            LatLngBounds bounds = builder.build();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));
        }
    }


    public void updateMap(ArrayList<WayPoint> pointList) {
        if (mMap != null) {
            mMap.clear();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (WayPoint wp : pointList) {
                BitmapDescriptor defaultMarker =
                        BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                mMap.addMarker(new MarkerOptions()
                        .position(wp.getCoordinate())
                        .title(wp.getTitle())
                        .icon(defaultMarker));
                builder.include(wp.getCoordinate());
            }
            LatLngBounds bounds = builder.build();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));
        }

    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        setUpMapIfNeeded();
//
//       // updatepMap();
//    }


    //@Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(10, 10))
                .title("Hello world"));
    }


    private void setUpMapIfNeeded() {
        if (mapFragment == null) {
//            mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
            mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        }
//        if (mMap == null){
//            ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
//        }

        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    mMap.setMyLocationEnabled(true);
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.481701, 30.747178))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("Impact Hub Odessa \f Греческая 1а"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.481876, 30.748382))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                            .title("Trattoria \f Греческая 1а"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.481949, 30.743978))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                            .title("Gretchka \f Греческая 7"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.482110, 30.741533))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                            .title("Fratelli \f Греческая 17"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.482253, 30.741111))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                            .title("Cooper Burgers \f Греческая 19"));

                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(46.479439, 30.748290))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                            .title("Santim \f Сабанский переулок 1"));

//                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(HUB, 0));

                }
            });
//            if (mMap != null) {
//                mMap.addMarker(new MarkerOptions().position(new LatLng(46.481701, 30.747178)).title(" Impact Hub Odessa"));
//            }
        }
    }

    private void setUpMap() {

        mMap.addMarker(new MarkerOptions().position(new LatLng(46.481701, 30.747178)).title(" Impact Hub Odessa"));
    }


    public static CustomMapFragment newInstance(int a) {
        CustomMapFragment fragment = new CustomMapFragment();
        Bundle args = new Bundle();
        //args.putInt(KEY,a);
        // fragment.setArguments(args);
        return fragment;
    }


}
