package com.example.b.test4;

import android.util.Log;
import android.app.Service;
import android.content.Intent;
import android.widget.Toast;
import android.os.IBinder;
/**
 * Created by b on 1/18/2016.
 */
public class AppMonitorService extends Service{

    @Override
    public final int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public final IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.appName,  this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
        Toast.makeText(this, "Service created...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
                Toast.makeText(this, "Service destroyed ...", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(Constants.appName, this.getClass().getCanonicalName() +":"+ MyUtil.methodName());
        Toast.makeText(getApplicationContext(), MyUtil.methodName(),Toast.LENGTH_LONG).show();

        try {
            stopService(new Intent(this, this.getClass()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            super.onTaskRemoved(rootIntent);
        } else{}
    }
}
