package com.laomo.switchdebug.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class Utils {

    public static void switchDebug(Context context) {
	// debug开关切换
	ContentResolver resolver = context.getContentResolver();
	Settings.Secure.putInt(resolver, Settings.Secure.ADB_ENABLED,
	    (1 - Settings.Secure.getInt(resolver, Settings.Secure.ADB_ENABLED, 0)));
	context.sendBroadcast(new Intent(Contant.ACTION_CHANGE_ICON));
    }

    public static void switchDebug(Context context, int adbEnabled) {
	ContentResolver resolver = context.getContentResolver();
	if (adbEnabled != Settings.Secure.getInt(resolver, Settings.Secure.ADB_ENABLED, 0)) {
	    Settings.Secure.putInt(resolver, Settings.Secure.ADB_ENABLED, adbEnabled);
	    context.sendBroadcast(new Intent(Contant.ACTION_CHANGE_ICON));
	}
    }

    public static void showToast(Context context, int msgResId) {
	Toast.makeText(context, msgResId, Toast.LENGTH_LONG).show();
    }
}
