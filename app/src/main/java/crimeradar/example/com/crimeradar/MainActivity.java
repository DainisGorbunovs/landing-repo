package crimeradar.example.com.crimeradar;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.BroadcastReceiver;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // use this to start and trigger a service
        Intent i= new Intent(getApplicationContext(), GeoWatchService.class);
// potentially add data to the intent
        i.putExtra("KEY1", "Value to be used by the service");

        LocationManager locService = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabledGPS = locService.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean enabledNetwork = locService.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean enabledManagers = enabledGPS || enabledNetwork;
        if(!enabledManagers)
        {
                Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent1);
                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
        }

        //Register BroadcastReceiver
        //to receive event from our service
        LocationChangeReceiver locationChangeReceiver = new LocationChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GeoWatchService.LOCATION_CHANGE);
        registerReceiver(locationChangeReceiver, intentFilter);

        getApplicationContext().startService(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class LocationChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            double lng = intent.getDoubleExtra("longitude", 0);
            double lat = intent.getDoubleExtra("latitude", 0);


        }

    }
}
