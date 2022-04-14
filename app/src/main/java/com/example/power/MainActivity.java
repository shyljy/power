package com.example.power;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private PowerConnectionReceiver powerConnectionReceiver;

    private BatteryLevelReceiver batteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        powerConnectionReceiver = new PowerConnectionReceiver();

        batteryLevelReceiver = new BatteryLevelReceiver();

        registerReceiver(powerConnectionReceiver, intentFilter);

        registerReceiver(batteryLevelReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(powerConnectionReceiver);

        unregisterReceiver(batteryLevelReceiver);
    }
}
