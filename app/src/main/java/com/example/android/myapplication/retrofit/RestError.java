package com.example.android.myapplication.retrofit;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

/**
 * Created by angebagui on 26/06/2015.
 *
 * {
 "message":"Email already exists.Please try another email.",
 "error":true,
 "status":409,
 }
 *
 *
 */
@Parcel
public class RestError {


    @SerializedName("status_code")
    public Integer statusCode;

    @SerializedName("status_message")
    public String statusMessage;

    public RestError() {
    }

    public RestError(String message) {
        this.statusMessage = message;
    }

    public String getMessage() {
        return statusMessage;
    }

    public void setMessage(String message) {
        this.statusMessage = message;
    }


    public Integer getStatus() {
        return statusCode;
    }

    public void setStatus(Integer status) {
        this.statusCode = status;
    }

}
