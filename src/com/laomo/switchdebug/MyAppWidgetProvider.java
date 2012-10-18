package com.laomo.switchdebug;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

    private RemoteViews remoteViews;

    @Override
    public void onReceive(Context context, Intent intent) {
	super.onReceive(context, intent);
	if (intent.getAction().equals("click_action")) {
	    Utils.switchDebug(context);
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
	Intent intentClick = new Intent("click_action");
	PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentClick, 0);
	remoteViews.setOnClickPendingIntent(R.id.my_widget_img, pendingIntent);
	appWidgeManger.updateAppWidget(appWidgetId, remoteViews);
    }
}
