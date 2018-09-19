package com.glocalfarm.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task")
public class Categories {


    @PrimaryKey(autoGenerate = true)
    private int id;
    private String imageUrl;
    private int priority;


}
