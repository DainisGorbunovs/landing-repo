package crimeradar.example.com.crimeradar;

import android.app.Service;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class GeoWatchService extends Service {
    public static String LOCATION_CHANGE = "LOCATION_CHANGE";
    public GeoWatchService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        Criteria locationCriteria = new Criteria();
        MyLocationListener locationListener = new MyLocationListener();
        LocationManager locService = (LocationManager) getSystemService(LOCATION_SERVICE);
        locService.requestLocationUpdates(locService.getBestProvider(locationCriteria, true), 2000, 0, locationListener);
        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementation
        return null;
    }

    public class MyLocationListener implements LocationListener{
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.i("Test provider:","Enabled");
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.i("Test provider:","Disabled");
        }

        @Override
        public void onLocationChanged(Location location) {
            double lat = (double) (location.getLatitude());
            double lng = (double) (location.getLongitude());

            Intent intent = new Intent();
            intent.setAction(LOCATION_CHANGE);

            intent.putExtra("longitude", lng);
            intent.putExtra("latitude", lat);

            sendBroadcast(intent);

            Log.i("Test latitude: ",String.valueOf(lat));
            Log.i("Test longitude: ", String.valueOf(lng));
        }
    }
}
