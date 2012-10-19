package com.laomo.switchdebug;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;

import com.laomo.switchdebug.service.USBService;

public class SettingActivity extends PreferenceActivity 
	//implements OnSharedPreferenceChangeListener 
	{

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.setting);
	//PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
    }

//    @Override
//    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//	if (key.equals("auto_switch")) {
//	    Boolean autoSwitch = sharedPreferences.getBoolean("auto_switch", false);
//	    Intent intent = new Intent(this,USBService.class);
//	    if(autoSwitch){
//		startService(intent);
//	    }else {
//		stopService(intent);
//	    }
//	    Log.d("TAG", "auto_switch:"+autoSwitch);
//	} else if (key.equals("only_connect")) {
//	    Boolean onlyConnect = sharedPreferences.getBoolean("only_connect", false);
//	    Log.d("TAG", "only_connect: " + onlyConnect);
//	}
//    }
    
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
	String key = preference.getKey();
	SharedPreferences sharedPreferences = preference.getSharedPreferences();
	if (key.equals("auto_switch")) {
	    Boolean autoSwitch = sharedPreferences.getBoolean("auto_switch", false);
	    Intent intent = new Intent(this,USBService.class);
	    if(autoSwitch){
		startService(intent);
	    }else {
		stopService(intent);
	    }
	    Log.d("TAG", "auto_switch:"+autoSwitch);
	} else if (key.equals("only_connect")) {
	    Boolean onlyConnect = sharedPreferences.getBoolean("only_connect", false);
	    Log.d("TAG", "only_connect: " + onlyConnect);
	} else if(key.equals("about")){
	    startActivity(new Intent(this,AboutActivity.class));
	}
        return true;
    }
}
