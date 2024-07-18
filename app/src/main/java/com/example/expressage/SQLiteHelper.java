package com.example.expressage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {


//    public SQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
    public SQLiteHelper( Context context) {
        super(context, "login.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table Guest(Gnum primary key,Gpassword,Game,Ggender,Gphone,Gaddress)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
