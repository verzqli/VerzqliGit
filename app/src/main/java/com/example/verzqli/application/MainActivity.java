package com.example.verzqli.application;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager = null;
    private Sensor gyroSensor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_ORIENTATION);
        Log.i(TAG, "onCreate: 重新commit11111111    commit3添加顺便修改了111111");

        Log.i(TAG, "onCreate: 重新commit222222222");

        Log.i(TAG, "onCreate: 重新commit222222222 回退版本顺便修改");


        Log.i(TAG, "onCreate: 第二次回退版本 然后加了东西zzzzz");
    }
}
