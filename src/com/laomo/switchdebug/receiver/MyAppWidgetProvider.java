package com.laomo.switchdebug.receiver;

import com.laomo.switchdebug.R;
import com.laomo.switchdebug.utils.Contant;
import com.laomo.switchdebug.utils.Utils;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

    private RemoteViews remoteViews;

    @Override
    public void onReceive(Context context, Intent intent) {
	super.onReceive(context, intent);
	String action = intent.getAction();
	if (action.equals(Contant.ACTION_CLICK_ACTION)) {
	    Utils.switchDebug(context);
	}else if (action.equals(Contant.ACTION_CHANGE_ICON)) {
	    updateIcon(context);
	}
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	super.onUpdate(context, appWidgetManager, appWidgetIds);
	final int N = appWidgetIds.length;
	for (int i = 0; i < N; i++) {
	    int appWidgetId = appWidgetIds[i];
	    updateAppWidget(context, appWidgetManager, appWidgetId);
	}
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgeManger, int appWidgetId) {
	remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
	Intent intentClick = new Intent(Contant.ACTION_CLICK_ACTION);
	PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentClick, 0);
	remoteViews.setOnClickPendingIntent(R.id.my_widget_img, pendingIntent);
	appWidgeManger.updateAppWidget(appWidgetId, remoteViews);
    }
    
    private void updateIcon(Context context){
	AppWidgetManager appWidgeManger = AppWidgetManager.getInstance(context);
	remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
	if (Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0) == 0) {
	    remoteViews.setImageViewResource(R.id.my_widget_img, R.drawable.ic_launcher_gray);
	} else {
	    remoteViews.setImageViewResource(R.id.my_widget_img, R.drawable.ic_launcher);
	}
	appWidgeManger.updateAppWidget(new ComponentName(context, MyAppWidgetProvider.class), remoteViews);
    }
}
