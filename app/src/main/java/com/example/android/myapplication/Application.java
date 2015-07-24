package com.example.android.myapplication;

import com.example.android.myapplication.util.AppSharedPreferences;

/**
 * Created by angebagui on 24/07/2015.
 */
public class Application extends android.app.Application {

    // Debugging switch
    public static final boolean APPDEBUG = true;

    // Debugging tag for the application
    public static final String APPTAG = "MyApplication";

    public static  AppSharedPreferences mPrefs;
    @Override
    public void onCreate() {
        super.onCreate();
        mPrefs = new AppSharedPreferences(this);

    }
}
