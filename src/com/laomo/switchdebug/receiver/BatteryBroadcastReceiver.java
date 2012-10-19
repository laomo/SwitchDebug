package com.laomo.switchdebug.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.preference.PreferenceManager;

import com.laomo.switchdebug.utils.Utils;

public class BatteryBroadcastReceiver extends BroadcastReceiver {
    private int prePlugged = -1;

    @Override
    public void onReceive(Context context, Intent intent) {
	//插入状态
	int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
	Utils.showToast(context, "plugged is :"+plugged);
	boolean onlyConnect = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("only_connect", true);
	if (prePlugged != plugged) {
	    prePlugged = plugged;
	    switch (plugged) {
		case 0://放电
		    //拔出usb线。关闭usb调试
		    Utils.switchDebug(context,0);
		    break;
		case BatteryManager.BATTERY_PLUGGED_USB://usb充电
		    if(!onlyConnect){
			//插入usb线。关闭usb调试
			Utils.switchDebug(context,1);
		    }
		    break;
		case BatteryManager.BATTERY_PLUGGED_AC://交流充电器
		default:
		    break;
	    }
	}
    }
}
