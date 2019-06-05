package com.example.admin.myproject.GoogleMap;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GoogleService extends Service implements LocationListener {
    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    double latitude, longitude;
    float speed;
    LocationManager locationManager;
    Location location;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;
    long notify_interval = 10000;
    public static String str_receiver = "com.example.admin.getlocation.receiver";
    Intent intent;


    public GoogleService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mTimer = new Timer();
        mTimer.schedule(new TimerTaskToGetLocation(), 1, notify_interval);
        intent = new Intent(str_receiver);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }


    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    private void fn_getlocation() {
        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!isGPSEnable && !isNetworkEnable) {

        } else {

            if (isNetworkEnable) {
                location = null;
                if (locationManager != null) {

                    if (ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, (LocationListener) this);
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    if (location != null) {

                        Log.e("latitude : ", location.getLatitude() + " longitude : " + location.getLongitude());
                        try {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            speed = location.getSpeed();
                        }catch (Exception e){

                        }
                        Log.e("*** Speed", "" + speed);
                        //fn_update(location);

//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

                    }
                }
            }


            if (isGPSEnable) {
                location = null;

                if (locationManager != null) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, (LocationListener) this);
                    location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    if (location != null) {
                        Log.e("latitude : ", location.getLatitude() + " longitude : " + location.getLongitude());
                        try {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            speed = location.getSpeed();
                        }catch (Exception e){

                        }
                        Log.e("*** Speed", "" + speed);
//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                        //fn_update(location);
                    }
                }
            }
        }

        fn_update(location);
    }

    private class TimerTaskToGetLocation extends TimerTask {
        @Override
        public void run() {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    fn_getlocation();

                    Log.e("*** Log Runnable", "");
                }
            });

        }
    }

    private void fn_update(Location location) {
        try {
            intent.putExtra("latitude", location.getLatitude() + "");
            intent.putExtra("longitude", location.getLongitude() + "");
            intent.putExtra("speed", location.getSpeed() + "");
            sendBroadcast(intent);
        }catch (Exception e){

        }
        /*Main3Activity main3Activity = new Main3Activity();
        main3Activity.login(latitude + "", longitude + "", speed + "");*/
    }

    @Override
    public void onDestroy() {
        fn_getlocation();
    }

}
