package com.example.dehradun;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;


import android.Manifest;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {
    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    private GeofencingClient geofencingClient;
    private GeofenceHelper geofenceHelper;

    private float GEOFENCE_RADIUS = 20;
    private String GEOFENCE_ID = "SOME_GEOFENCE_ID";

    private int FINE_LOCATION_ACCESS_REQUEST_CODE = 10001;
    private int BACKGROUND_LOCATION_ACCESS_REQUEST_CODE = 10002;
    private static final LatLng Traffic = new LatLng(13.0841, 79.6704);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        geofencingClient = LocationServices.getGeofencingClient(this);
        geofenceHelper = new GeofenceHelper(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        String caller = getIntent().getStringExtra("Sel");
        mMap = googleMap;
        googleMap.setTrafficEnabled(true);
        enableUserLocation();
        mMap.setOnMapLongClickListener(this);

        if (caller.equals("Laxmanchowk")) {
            LatLng LaxmanChowk = new LatLng(30.317862, 78.024663);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LaxmanChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(LaxmanChowk).title("Marker in Laxman Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(LaxmanChowk));
        } else if (caller.equals("Rajivchowk")) {
            LatLng Rajivchowk = new LatLng(30.3238, 78.0201);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rajivchowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Rajivchowk).title("Marker in Rajiv Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajivchowk));
        } else if (caller.equals("Saharanpur")) {
            LatLng Saharanpur = new LatLng(30.317489, 78.028964);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Saharanpur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Saharanpur).title("Marker in Saharanpur Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Saharanpur));
        } else if (caller.equals("Shampur")) {
            LatLng Sarampur = new LatLng(30.320052, 78.032556);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sarampur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Sarampur).title("Marker in Shampur Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sarampur));
        } else if (caller.equals("Pipalmilndi")) {
            LatLng Sarampur = new LatLng(30.318456, 78.034663);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sarampur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Sarampur).title("Marker in Pipalmilndi Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sarampur));
        } else if (caller.equals("Lakhibagh")) {
            LatLng Sarampur = new LatLng(30.314752, 78.027843);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sarampur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Sarampur).title("Marker in Lakhibagh Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sarampur));
        } else if (caller.equals("Bhandari")) {
            LatLng Sarampur = new LatLng(30.3193, 78.0324);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sarampur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Sarampur).title("Marker in Bhandari Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sarampur));
        } else if (caller.equals("Hanumanchowk")) {
            LatLng Sarampur = new LatLng(30.3185, 78.0335);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sarampur, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Sarampur).title("Marker in Hanuman Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sarampur));
        } else if (caller.equals("RailwayStationChowk")) {
            LatLng RailwayStationChowk = new LatLng(30.316176, 78.034234);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RailwayStationChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(RailwayStationChowk).title("Marker in RailwayStation Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(RailwayStationChowk));
        } else if (caller.equals("BindalChowk")) {
            LatLng BindalChowk = new LatLng(30.326703, 78.033258);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BindalChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(BindalChowk).title("Marker in Bindal Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(BindalChowk));
        } else if (caller.equals("PrinceChowk")) {
            LatLng PrinceChowk = new LatLng(30.31570, 78.037523);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PrinceChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(PrinceChowk).title("Marker in Prince Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(PrinceChowk));
        } else if (caller.equals("TehsilChowk")) {
            LatLng TehsilChowk = new LatLng(30.320719, 78.040985);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TehsilChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(TehsilChowk).title("Marker in Tehsil Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(TehsilChowk));
        } else if (caller.equals("MottibazaarChowk")) {
            LatLng MotibazaarChowk = new LatLng(30.321522, 78.037511);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MotibazaarChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(MotibazaarChowk).title("Marker in Motibazaar Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(MotibazaarChowk));
        } else if (caller.equals("CmiChowk")) {
            LatLng CmiChowk = new LatLng(30.312470, 78.047992);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CmiChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(CmiChowk).title("Marker in Cmi Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(CmiChowk));
        } else if (caller.equals("AragharChowk")) {
            LatLng AragharChowk = new LatLng(30.309617, 78.048904);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AragharChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(AragharChowk).title("Marker in Araghar Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(AragharChowk));
        } else if (caller.equals("Dwarka")) {
            LatLng Dwarka = new LatLng(30.286297, 78.065827);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dwarka, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Dwarka).title("Marker in Dwarka Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Dwarka));
        } else if (caller.equals("CityheartCenterChowk")) {
            LatLng CityheartCenter = new LatLng(30.319754, 78.050518);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CityheartCenter, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(CityheartCenter).title("Marker in CityheartCenter Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(CityheartCenter));
        } else if (caller.equals("DoonHospitalChowk")) {
            LatLng DoonHospitalChowk = new LatLng(30.320211, 78.041980);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DoonHospitalChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(DoonHospitalChowk).title("Marker in DoonHospital Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(DoonHospitalChowk));
        } else if (caller.equals("MKPChowk")) {
            LatLng MKPChowk = new LatLng(30.317417, 78.045951);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MKPChowk, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(MKPChowk).title("Marker in MKPChowk Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(MKPChowk));
        } else if (caller.equals("Clocktower")) {
            LatLng Clocktower = new LatLng(30.324298, 78.041799);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Clocktower, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Clocktower).title("Marker in Clocktower"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Clocktower));
        } else if (caller.equals("BudhaPark")) {
            LatLng BudhaPark = new LatLng(30.321941, 78.045412);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BudhaPark, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(BudhaPark).title("Marker in BudhaPark Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(BudhaPark));
        } else if (caller.equals("DarshanlalChowk")) {
            LatLng Darshanlal = new LatLng(30.322607, 78.042541);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Darshanlal, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Darshanlal).title("Marker in Darshanlal Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Darshanlal));
        } else if (caller.equals("CityheartcenterChowk")) {
            LatLng Cityarccenter = new LatLng(30.319748, 78.050528);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Cityarccenter, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Cityarccenter).title("Marker in Cityarccenter Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Cityarccenter));
        } else if (caller.equals("Kanak")) {
            LatLng Kanak = new LatLng(30.326837, 78.047673);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kanak, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Kanak).title("Marker in Kanak Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Kanak));
        } else if (caller.equals("Kwality")) {
            LatLng Kwality = new LatLng(30.327700, 78.045668);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kwality, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Kwality).title("Marker in Kwality Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Kwality));
        } else if (caller.equals("Lansdowne")) {
            LatLng Lansdowne = new LatLng(30.323777, 78.045586);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Lansdowne, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Lansdowne).title("Marker in Lansdowne Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Lansdowne));
        } else if (caller.equals("Survey")) {
            LatLng Survey = new LatLng(30.324783, 78.051681);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Survey, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Survey).title("Marker in Survey Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Survey));
        } else if (caller.equals("NanysBakery")) {
            LatLng NanysBakery = new LatLng(30.332181, 78.053578);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NanysBakery, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(NanysBakery).title("Marker in NanysBakery Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(NanysBakery));
        } else if (caller.equals("Bhel")) {
            LatLng Bhel = new LatLng(30.334372, 78.052457);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bhel, (float) 20.0));
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng LatLng) {
                        mMap.clear();
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(LatLng);
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(LatLng));
                        Marker marker = mMap.addMarker(markerOptions);
                        marker.showInfoWindow();
                    }
                });
        } else if (caller.equals("Globe")) {
            LatLng Globe = new LatLng(30.329013, 78.046667);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Globe, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Globe).title("Marker in Globe Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Globe));
        } else if (caller.equals("NishvilaChowk")) {
            LatLng Nishvila = new LatLng(30.328371, 78.045956);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Nishvila, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Nishvila).title("Marker in Nishvila Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Nishvila));
        } else if (caller.equals("Dilaram")) {
            LatLng Dilaram = new LatLng(30.335931, 78.054796);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dilaram, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(Dilaram).title("Marker in Dilaram Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Dilaram));
        } else if (caller.equals("DBS")) {
            LatLng DBS = new LatLng(30.330166, 78.060565);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DBS, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(DBS).title("Marker in DBS Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(DBS));
        } else if (caller.equals("DAV")) {
            LatLng DAV = new LatLng(30.328336, 78.057017);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DAV, (float) 20.0));
            mMap.addMarker(new MarkerOptions().position(DAV).title("Marker in Karanpur Chowk"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(DAV));
        }

    }

    private void enableUserLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_ACCESS_REQUEST_CODE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_ACCESS_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == FINE_LOCATION_ACCESS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //We have the permission
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mMap.setMyLocationEnabled(true);
            } else {
                //We do not have the permission..

            }
        }

        if (requestCode == BACKGROUND_LOCATION_ACCESS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //We have the permission
                Toast.makeText(this, "You can add geofences...", Toast.LENGTH_SHORT).show();
            } else {
                //We do not have the permission..
                Toast.makeText(this, "Background location access is neccessary for geofences to trigger...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onMapLongClick(LatLng latLng) {
        if (Build.VERSION.SDK_INT >= 29) {
            //We need background permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                handleMapLongClick(latLng);
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                    //We show a dialog and ask for permission
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}, BACKGROUND_LOCATION_ACCESS_REQUEST_CODE);
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}, BACKGROUND_LOCATION_ACCESS_REQUEST_CODE);
                }
            }

        } else {
            handleMapLongClick(latLng);
        }

    }

    private void handleMapLongClick(LatLng latLng) {
        addCircle(latLng, GEOFENCE_RADIUS);
        addGeofence(latLng, GEOFENCE_RADIUS);
    }

    private void addGeofence(LatLng latLng, float radius) {

        Geofence geofence = geofenceHelper.getGeofence(GEOFENCE_ID, latLng, radius, Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_DWELL | Geofence.GEOFENCE_TRANSITION_EXIT);
        GeofencingRequest geofencingRequest = geofenceHelper.getGeofencingRequest(geofence);
        PendingIntent pendingIntent = geofenceHelper.getPendingIntent();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        geofencingClient.addGeofences(geofencingRequest, pendingIntent)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "onSuccess: Geofence Added...");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String errorMessage = geofenceHelper.getErrorString(e);
                        Log.d(TAG, "onFailure: " + errorMessage);
                    }
                });
    }

    private void addMarker(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions().position(latLng);
        mMap.addMarker(markerOptions);
    }

    private void addCircle(LatLng latLng, float radius) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(latLng);
        circleOptions.radius(radius);
        circleOptions.strokeColor(Color.argb(255, 255, 0, 0));
        circleOptions.fillColor(Color.argb(64, 255, 0, 0));
        circleOptions.strokeWidth(4);
        mMap.addCircle(circleOptions);
    }
}
