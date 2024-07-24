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

    public boolean insertUser( String Fnum, String num, String identity, String Dnum, String Hname){
        ContentValues values = new ContentValues();

        values.put("Fnum",Fnum);
        values.put("num",num);
        values.put("identity",identity);
        values.put("Dnum",Dnum);
        values.put("Hname",Hname);


        //第一个是表名，第二个null，第三个是相当于sql插入语句的values
        //id用于判断是否插入成功： 如果大于0则表示插入了至少一条数据，否则插入失败
        long id = sqLiteDatabase.insert("finish",null, values);

        return id>0?true:false;
    }
    @SuppressLint("Range")
    public courier_finish_Bean querryUser(String Gnum, String Send_info, String Get_info, String name, String phone, String state){

        Cursor cursor = sqLiteDatabase.query("finish",new String[]{"Send_info","Get_info","name","phone","state"},"  Send_info=? and Get_info=? and name=?and phone=?and state=?",new String[]{Gnum,Send_info,Get_info,name,phone,state},null,null,null);

        courier_finish_Bean finishBean = new courier_finish_Bean(Send_info,Get_info,name,phone,state);
        while (cursor.moveToNext()){
            finishBean.setFnum(cursor.getString(cursor.getColumnIndex("Send_info")));
            finishBean.setnum(cursor.getString(cursor.getColumnIndex("Get_info")));
            finishBean.setidentity(cursor.getString(cursor.getColumnIndex("Sserver")));
            finishBean.setDnum(cursor.getString(cursor.getColumnIndex("Sway")));
            finishBean.setHname(cursor.getString(cursor.getColumnIndex("num")));


//            Log.e("tag", userBean.getGnum() + "|" + userBean.getGname() + "|" + userBean.getGgender() + "|" + userBean.getGphone() + "|" + userBean.getGaddress());

        }
        cursor.close();
        return finishBean;
    }
}
