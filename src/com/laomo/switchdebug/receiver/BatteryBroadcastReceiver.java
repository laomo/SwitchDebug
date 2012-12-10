package com.laomo.switchdebug.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.preference.PreferenceManager;

import com.laomo.switchdebug.R;
import com.laomo.switchdebug.utils.Contant;
import com.laomo.switchdebug.utils.Utils;

public class BatteryBroadcastReceiver extends BroadcastReceiver {
    private int prePlugged = -1;

    @Override
    public void onReceive(Context context, Intent intent) {
	//插入状态
	int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
	if (prePlugged != plugged) {
	    prePlugged = plugged;
	    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	    Boolean autoSwitch = sharedPreferences.getBoolean(Contant.AUTO_SWITCH, false);
	    if (autoSwitch) {
		switch (plugged) {
		    case 0://放电
			   //拔出usb线。关闭usb调试
			Utils.switchDebug(context, 0);
			Utils.showToast(context, R.string.close_tips);
			break;
		    case BatteryManager.BATTERY_PLUGGED_USB://usb充电
			boolean onlyConnect = sharedPreferences.getBoolean(Contant.ONLY_CONNECT, true);
			if (!onlyConnect) {
			    //插入usb线。打开usb调试
			    Utils.switchDebug(context, 1);
			    Utils.showToast(context, R.string.open_tips);
			}
			break;
		    case BatteryManager.BATTERY_PLUGGED_AC://交流充电器
		    default:
			break;
		}
	    }
	}
    }
}
