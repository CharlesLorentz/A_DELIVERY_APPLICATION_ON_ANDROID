package com.example.expressage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.expressage.SQLiteHelper;

public class BaseDao {
    protected SQLiteDatabase db;

    public BaseDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        //初始化刚刚写的MySQLiteHelper对象
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
//        SQLiteHelper sqLiteHelper = new SQLiteHelper(context, name, factory, version);
        //获取sqLiteDatabase对象
        db = sqLiteHelper.getWritableDatabase();
    }

}
