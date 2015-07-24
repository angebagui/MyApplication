package com.example.android.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.myapplication.Application;

/**
 * Created by angebagui on 24/07/2015.
 */
public class NetworkOperationService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Application.APPDEBUG){
            Log.d(Application.APPTAG, "NetworkOperationService has been created");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Application.APPDEBUG){
            Log.d(Application.APPTAG, "NetworkOperationService has been destroyed");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Application.APPDEBUG){
            Log.d(Application.APPTAG, "NetworkOperationService has been started");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
