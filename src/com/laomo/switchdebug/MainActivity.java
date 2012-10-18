package com.laomo.switchdebug;

import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (hasRoot()) {
			// debug开关切换
			Settings.Secure.putInt(getContentResolver(),
					Settings.Secure.ADB_ENABLED, 1 - Settings.Secure.getInt(
							getContentResolver(), Settings.Secure.ADB_ENABLED,
							0));
		} else {
			Toast.makeText(this, R.string.not_root, Toast.LENGTH_LONG).show();
		}
		finish();
	}

	public static boolean hasRoot() {
		char[] arrayOfChar = new char[1024];
		try {
			int j = new InputStreamReader(Runtime.getRuntime().exec("su -c ls")
					.getErrorStream()).read(arrayOfChar);
			if (j == -1) {
				return true;
			}
		} catch (IOException e) {
		}
		return false;
	}

}
