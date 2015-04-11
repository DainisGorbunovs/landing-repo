package crimeradar.example.com.crimeradar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GeoWatchService extends Service {
    public GeoWatchService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
