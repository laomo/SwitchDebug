package com.laomo.switchdebug;

import com.laomo.switchdebug.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	Utils.switchDebug(this);
	finish();
    }

}
