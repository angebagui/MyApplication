package com.example.android.myapplication.ormlite.entity;

import com.j256.ormlite.field.DatabaseField;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by angebagui on 02/06/15.
 */
@Parcel
public abstract class BaseColumn{
    @DatabaseField(generatedId = true, columnName = "_id")
    private Long internalId;
    @DatabaseField(columnName = "create_date")
    private String createDate;
    @DatabaseField(columnName = "update_date")
    private String updateDate;

    public long getId() {
        return internalId;
    }

    public void setId(long id) {
        this.internalId = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}

