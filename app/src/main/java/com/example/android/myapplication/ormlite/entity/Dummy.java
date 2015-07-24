package com.example.android.myapplication.ormlite.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by angebagui on 23/07/2015.
 */
public class Dummy extends BaseColumn {

    @SerializedName("avatar")
    public String avatar;
    @SerializedName("content")
    public String content;
}
