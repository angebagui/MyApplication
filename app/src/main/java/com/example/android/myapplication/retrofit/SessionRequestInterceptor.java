package com.example.android.myapplication.retrofit;

import retrofit.RequestInterceptor;

/**
 * Created by angebagui on 26/06/2015.
 */
public class SessionRequestInterceptor implements RequestInterceptor {
    private static final String TAG = SessionRequestInterceptor.class.getSimpleName();

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Content-Type", "application/json");//you can add header here if you need in your api
    }
}
