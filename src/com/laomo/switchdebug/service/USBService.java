package com.laomo.switchdebug.service;

import com.laomo.switchdebug.receiver.BatteryBroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class USBService extends Service {

    private boolean hasRegister = false;
    private BatteryBroadcastReceiver receiver = new BatteryBroadcastReceiver();

    @Override
    public IBinder onBind(Intent intent) {
	return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
	if (!hasRegister) {
	    registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	    hasRegister = true;
	}
	return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
	super.onDestroy();
	unregisterReceiver(receiver);
    }

}
