package com.example.android.myapplication.util;

import android.content.Context;

/**
 * Created by angebagui on 23/07/2015.
 */
public class MyConstants {

    public static final int PREFS_MODE = Context.MODE_PRIVATE;

    public static final String PREFS_NAME = "com.example.android.myapplication.PREFS_NAME";

    public interface MyDB {
        public final static String DATABASE_NAME = "com.example.android.myapplication_lite.db";

        public final static int DATABASE_VERSION = 1;
    }
}
