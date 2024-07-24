package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class courier_finish_Dao {
    private SQLiteDatabase sqLiteDatabase;
    public courier_finish_Dao(Context context){
//    public UserDao(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version){
//        super(context, name, factory, version);
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        //获取sqLiteDatabase对象
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
    }

    public boolean insertUser(String num,String identity,String com_num,String com_identity,String Hname){
        ContentValues values = new ContentValues();

        values.put("num",num);
        values.put("identity",identity);
        values.put("com_num",com_num);
        values.put("com_identity",com_identity);
        values.put("Hname",Hname);


        //第一个是表名，第二个null，第三个是相当于sql插入语句的values
        //id用于判断是否插入成功： 如果大于0则表示插入了至少一条数据，否则插入失败
        long id = sqLiteDatabase.insert("finish",null, values);

        return id>0?true:false;
    }

}
