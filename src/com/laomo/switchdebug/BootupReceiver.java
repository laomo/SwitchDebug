package com.laomo.switchdebug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         context.startService(new Intent(context,USBService.class));
    }
}
