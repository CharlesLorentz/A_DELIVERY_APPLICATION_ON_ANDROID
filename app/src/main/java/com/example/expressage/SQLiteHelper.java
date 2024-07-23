package com.example.expressage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String CREATE_USER_TABLE="create table user(num,identity,password,name,gender,phone,address,primary key(num,identity))";
    private static final String CREATE_SEND_TABLE="create table send(Send_info,Get_info,Sserver, Sway)";

    //    public SQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
    public SQLiteHelper( Context context) {
        super(context, "user.db", null, 1);
    }

    /**
     * 创建数据库表的初始化
     *
     * @author macargen
     * @param sqLiteDatabase The database.
     *
     */
    public void onCreate(SQLiteDatabase sqLiteDatabase){
       sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_SEND_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
