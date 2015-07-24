package com.example.android.myapplication.retrofit;


import com.example.android.myapplication.operation.entity.DummieContent;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by angebagui on 27/06/2015.
 */
public interface GithubService {

    // "/api/42/getDummieContent?sort=desc"
    @GET("/api/{id}/getDummieContent")
    public DummieContent getDummieContent(@Path("id") Integer id, @Query("sort") String strTest);

    /**
     * The methods in your interface return a DummyContent this means
     * that your request is synchronized and your execution will block until the request finish.
     * If you want to create an asynchronized request you have to add a
     * Callback to your methods and return void.

     */
    // "/api/42/getDummieContent?sort=desc"
    @GET("/api/{id}/getDummieContent")
    void getDummieContent(@Path("id") Integer id, @Query("sort") String strSort, RestCallback<DummieContent> callback);


}
