//package com.laomo.switchdebug;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.hardware.usb.UsbManager;
//import android.os.BatteryManager;
//
//public class USBBroadcastReceiver extends BroadcastReceiver {
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//	String action = intent.getAction();
//	if (UsbManager.ACTION_USB_ACCESSORY_ATTACHED.equals(action)) {
//	    Toast.makeText(context, "ACCESSORY_ATTACHED", Toast.LENGTH_LONG).show();
//	} else if (UsbManager.ACTION_USB_ACCESSORY_DETACHED.equals(action)) {
//	    Toast.makeText(context, "ACCESSORY_DETACHED", Toast.LENGTH_LONG).show();
//	} else if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
//	    Toast.makeText(context, "DEVICE_ATTACHED", Toast.LENGTH_LONG).show();
//	} else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
//	    Toast.makeText(context, "DEVICE_DETACHED", Toast.LENGTH_LONG).show();
//	}
//    }
//}
