package com.example.expressage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String CREATE_USER_TABLE="create table user(num,identity,password,name,gender,phone,address,primary key(num,identity))";
    private static final String CREATE_SEND_TABLE="create table send(NDNum integer primary key autoincrement,num,identity,Sname,Sphone,Sadress,Hname,Cname,state,foreign key(num,identity) REFERENCES user(num,identity))";
    private static final String CREATE_GET_TABLE="create table finish(Fnum integer primary key autoincrement,num,identity,com_num,com_identity,Hname,state,foreign key(num,identity) REFERENCES user(num, identity),foreign key(com_num,com_identity) REFERENCES user(num, identity))";
    private static final String CREATE_COMMENT_TABLE="create table comment(ID integer primary key autoincrement,Type,sendNum,finishNum,Content,Grade1,Grade2,Grade3,foreign key(sendNum) REFERENCES send(NDNum),foreign key(finishNum) REFERENCES finish(FNum))";

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
        sqLiteDatabase.execSQL(CREATE_GET_TABLE);
        sqLiteDatabase.execSQL(CREATE_COMMENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
