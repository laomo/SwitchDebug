package com.laomo.switchdebug;

import com.laomo.switchdebug.service.USBService;
import com.laomo.switchdebug.utils.Contant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.util.Log;

public class SettingActivity extends PreferenceActivity
{

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.setting);
	startService(new Intent(this, USBService.class));
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
	String key = preference.getKey();
	SharedPreferences sharedPreferences = preference.getSharedPreferences();
	if (key.equals(Contant.AUTO_SWITCH)) {
	    Boolean autoSwitch = sharedPreferences.getBoolean(Contant.AUTO_SWITCH, false);
	    Log.d("TAG", "auto_switch:" + autoSwitch);
	} else if (key.equals(Contant.ONLY_CONNECT)) {
	    Boolean onlyConnect = sharedPreferences.getBoolean(Contant.ONLY_CONNECT, false);
	    Log.d("TAG", "only_connect: " + onlyConnect);
	} else if (key.equals(Contant.ABOUT)) {
	    startActivity(new Intent(this, AboutActivity.class));
	}
	return true;
    }
}
