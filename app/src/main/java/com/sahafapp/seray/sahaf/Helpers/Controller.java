package com.sahafapp.seray.sahaf.Helpers;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class Controller extends Application {

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }
}
