package com.laomo.switchdebug;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class USBService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
	return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
	registerReceiver(new BatteryBroadcastReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	return super.onStartCommand(intent, flags, startId);
    }

}
