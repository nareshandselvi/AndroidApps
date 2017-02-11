package com.example.windows_home.screenonoff;
import android.app.Service;
import android.hardware.SensorEventListener;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.hardware.SensorManager;
import android.os.IBinder;

public class MyLockScreenActivity extends Service implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    //private boolean isRunning  = false;
    private static final String TAG = "HelloService";
    public int count=0;
    public long  TimeOld,TimeNew,TimeDelay;

    @Override
    public void onCreate() {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager.registerListener(this, mSensor,SensorManager.SENSOR_DELAY_NORMAL);
        //isRunning = true;
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public int onStartCommand(Intent intent, int flags, int startId)
    {
          return Service.START_STICKY;

    }


    public void onSensorChanged(SensorEvent event) {
        if ( count != 2 ) {
            TimeOld = event.timestamp;
            count = 2;
            return;
        }
        TimeNew = event.timestamp;
        TimeDelay = TimeNew - TimeOld;
        Log.d("TimeDealy", "Value: " + String.valueOf(TimeDelay));

        if ( TimeDelay < 1000000000 )

        {
            if (event.values[0] == 0
                    ) {
                PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                WakeLock wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
                        | PowerManager.ACQUIRE_CAUSES_WAKEUP
                        | PowerManager.ON_AFTER_RELEASE, "MyWakeLock");
                count = 0;
                wakeLock.acquire();
                wakeLock.release();
            }
        }
        else
            TimeOld = TimeNew;
            count = 2;
    }



    @Override
    public void onDestroy() {
        mSensorManager.unregisterListener(this, mSensor);
        Log.i(TAG, "Service onDestroy");
    }

}