package com.example.power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryLevelReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        //判断当前电池电量
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float)scale;
        //电池电量状态
        Log.d("BatteryLevelReceiver", "电量：" + batteryPct);
        if (batteryPct <= 0.2) {
            Log.d("BatteryLevelReceiver", "电量较低");
        }
        if (batteryPct > 0.2) {
            Log.d("BatteryLevelReceiver", "电量充足");
        }
        Log.i("BatteryLevelReceiver","电量："+batteryPct);
    }
}

