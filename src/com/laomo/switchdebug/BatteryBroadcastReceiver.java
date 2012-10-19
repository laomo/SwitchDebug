package com.laomo.switchdebug;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.provider.Settings;
import android.widget.Toast;

public class BatteryBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
	//插入状态
	int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
	Toast.makeText(context, "plugged is :"+plugged, Toast.LENGTH_LONG).show();
	ContentResolver resolver = context.getContentResolver();
	switch (plugged) {
	    case 0://放电
		// debug开关切换
		if (0 != Settings.Secure.getInt(resolver, Settings.Secure.ADB_ENABLED, 0)) {
		    Settings.Secure.putInt(resolver, Settings.Secure.ADB_ENABLED, 0);
		}
		break;
	    case BatteryManager.BATTERY_PLUGGED_USB://usb充电
		if (1 != Settings.Secure.getInt(resolver, Settings.Secure.ADB_ENABLED, 0)) {
		    Settings.Secure.putInt(resolver, Settings.Secure.ADB_ENABLED, 1);
		}
		break;
	    case BatteryManager.BATTERY_PLUGGED_AC://交流充电器
	    default:
		break;
	}
    }
}
