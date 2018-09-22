package com.lanyou.lpc.readassets.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/6/8.
 */
public class Db extends SQLiteOpenHelper {

    public static final  String DB_NAME = "db";
    public static final  String DB_TABLE = "user";

    public Db(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE+"( name varchar(20) , sex varchar(10) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
