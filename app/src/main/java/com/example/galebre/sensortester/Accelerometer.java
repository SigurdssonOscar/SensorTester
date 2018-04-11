package com.example.galebre.sensortester;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private TextView txt_x, txt_y, txt_z;
    private SensorManager SensorM;
    private Sensor mAccelerometer;
    private DecimalFormat DF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        DF = new DecimalFormat("#0.0000");
        txt_x = (TextView) findViewById(R.id.Xdisplay);
        txt_y = (TextView) findViewById(R.id.Ydisplay);
        txt_z = (TextView) findViewById(R.id.Zdisplay);

        SensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = SensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        txt_x.setText(DF.format(x));
        txt_y.setText(DF.format(y));
        txt_z.setText(DF.format(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorM.unregisterListener(this, mAccelerometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SensorM.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}

