package com.myapplicationdev.android.p08_ps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    Marker north_place,central_place,east_place;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.equals(north_place)){
                            Toast.makeText(getApplicationContext(),"HQ North is clicked!",Toast.LENGTH_LONG).show();
                        }else if(marker.equals(central_place)){
                            Toast.makeText(getApplicationContext(),"HQ Central is clicked!",Toast.LENGTH_LONG).show();
                        }else if(marker.equals(east_place)){
                            Toast.makeText(getApplicationContext(),"HQ East is clicked!",Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }


                LatLng sg = new LatLng(1.290270, 103.851959);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(sg,11));

                LatLng north = new LatLng(1.461708, 103.813500);

                north_place = map.addMarker(new
                        MarkerOptions()
                        .position(north)
                        .title("HQ - North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


                LatLng central = new LatLng(1.300542, 103.841226);
                central_place = map.addMarker(new
                        MarkerOptions()
                        .position(central)
                        .title("HQ - Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng east = new LatLng(1.350057, 103.934452);
                east_place = map.addMarker(new
                        MarkerOptions()
                        .position(east)
                        .title("HQ - East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));





            }
        });
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(map != null){
                    LatLng north = new LatLng(1.461708, 103.813500);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(north,15));

                    north_place = map.addMarker(new
                            MarkerOptions()
                            .position(north)
                            .title("HQ - North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                    "Tel:65433456\n")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(map != null){
                    LatLng central = new LatLng(1.300542, 103.841226);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(central,15));

                    central_place = map.addMarker(new
                            MarkerOptions()
                            .position(central)
                            .title("HQ - Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n" +
                                    "Tel:67788652\n")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(map != null){
                    LatLng east = new LatLng(1.350057, 103.934452);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(east,15));

                    east_place = map.addMarker(new
                            MarkerOptions()
                            .position(east)
                            .title("HQ - East")
                            .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677\n")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                }
            }
        });
    }
    public void onMarkerClick(final Marker marker){
        if(marker.equals(north_place)){
            Toast.makeText(getApplicationContext(),"HQ North is clicked!",Toast.LENGTH_LONG).show();
        }else if(marker.equals(central_place)){
            Toast.makeText(getApplicationContext(),"HQ Central is clicked!",Toast.LENGTH_LONG).show();
        }else if(marker.equals(east_place)){
            Toast.makeText(getApplicationContext(),"HQ East is clicked!",Toast.LENGTH_LONG).show();
        }
    }
}
