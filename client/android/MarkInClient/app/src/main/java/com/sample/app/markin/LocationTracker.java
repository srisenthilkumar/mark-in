package com.sample.app.markin;

import android.app.IntentService;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;

/**
 * Created by salagumalai on 14-04-2016.
 */
public class LocationTracker extends IntentService {

    private LocationManager locationManager;
    private String provider;
   // private LocationReciever locationReciever;

    public LocationTracker()
    {
        super("LocationTrackService");
       // locationReciever = new LocationReciever();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String d = intent.getDataString();
        try{
                Thread.sleep(new Long(100*100));
        }catch (InterruptedException e)
        {
            Log.i("LocationTrackService", e.getMessage());
        }

        Log.i("LocationTrackService", "Loading Intent event");

        //locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    }

   /* class LocationReciever implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            //location.getLongitude() + " lat: " + location.getLatitude()
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }*/

}
