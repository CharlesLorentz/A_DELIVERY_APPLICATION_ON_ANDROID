package com.example.expressage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String CREATE_USER_TABLE="create table user(Gnum text primary key,Gpassword text,Gname text,Ggender text,Gphone text,Gaddress text)";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
