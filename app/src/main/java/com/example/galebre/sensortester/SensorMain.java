package com.example.galebre.sensortester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SensorMain extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_main);
    }

    public void startCompass(View view){
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void startAccelerometer(View view){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }
}
