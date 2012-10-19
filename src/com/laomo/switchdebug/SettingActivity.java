package com.laomo.switchdebug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SettingActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	startService(new Intent(this,USBService.class));
	Toast.makeText(this, R.string.auto_switch, Toast.LENGTH_LONG).show();
    }

}
