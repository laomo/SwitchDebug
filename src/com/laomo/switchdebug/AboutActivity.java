package com.laomo.switchdebug;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TextView textView = (TextView) findViewById(R.id.site);
        Linkify.addLinks(textView, Linkify.WEB_URLS);
    }
}
