package com.example.android.myapplication.retrofit;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by angebagui on 26/06/2015.
 */
public class RestClient {

    private static GithubService service;
    public static final String API_URL = "ADD YOUR BASE URL";

    static {
        setupRestClient();
    }

    private RestClient() {}

    public static GithubService get() {
        return service;
    }

    private static void setupRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setRequestInterceptor(new SessionRequestInterceptor())
                .build();

        service = restAdapter.create(GithubService.class);
    }

}
