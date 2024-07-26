package com.example.expressage;

import android.database.sqlite.SQLiteDatabase;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class customer_send_Dao {
    private SQLiteDatabase sqLiteDatabase;
    public customer_send_Dao(Context context){
//    public UserDao(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version){
//        super(context, name, factory, version);
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        //获取sqLiteDatabase对象
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
    }
    public boolean insertUser(String num,String identity,String Sname, String Sphone, String Sadress, String Hname, String Cname,String state){
        ContentValues values = new ContentValues();

        values.put("num",num);
        values.put("identity",identity);
        values.put("Sname",Sname);
        values.put("Sphone",Sphone);
        values.put("Sadress",Sadress);
        values.put("Hname",Hname);
        values.put("Cname",Cname);
        values.put("state",state);


        //第一个是表名，第二个null，第三个是相当于sql插入语句的values
        //id用于判断是否插入成功： 如果大于0则表示插入了至少一条数据，否则插入失败
        long id = sqLiteDatabase.insert("send",null, values);

        return id>0?true:false;
    }
    @SuppressLint("Range")
//    public customer_send_Bean querryUser(String Gnum, String Send_info, String Get_info, String Sserver, String Sway){
//
//        Cursor cursor = sqLiteDatabase.query("send",new String[]{"num","Send_info","Get_info","Sserver","Sway"},"num=? and Send_info=? and Get_info=? and Sserver=?and Sway=?",new String[]{Gnum,Send_info,Get_info,Sserver,Sway},null,null,null);
//
//        customer_send_Bean sendBean = new customer_send_Bean(Gnum,Get_info,Sserver,Sway);
//        while (cursor.moveToNext()){
//            sendBean.setGnum(cursor.getString(cursor.getColumnIndex("num")));
//            sendBean.setSend_info(cursor.getString(cursor.getColumnIndex("Send_info")));
//            sendBean.setGet_info(cursor.getString(cursor.getColumnIndex("Get_info")));
//            sendBean.setSserver(cursor.getString(cursor.getColumnIndex("Sserver")));
//            sendBean.setSway(cursor.getString(cursor.getColumnIndex("Sway")));
//
//
////            Log.e("tag", userBean.getGnum() + "|" + userBean.getGname() + "|" + userBean.getGgender() + "|" + userBean.getGphone() + "|" + userBean.getGaddress());
//
//        }
//        cursor.close();
//        return sendBean;
//    }
    public boolean updateUser(String num,String identity){
        Boolean flag;
        ContentValues values = new ContentValues();
        values.put("num",num);
        values.put("identity",identity);
        values.put("state","已送达");
        long id = sqLiteDatabase.update("send",values,"num = ? ",new String[]{num});
        flag = id > 0?true : false;
        return true;
    }
    public boolean deleteUser(){
        sqLiteDatabase.delete("send", null, null);
        //        long id = sqLiteDatabase.delete("user","username = ?",new String[]{username});
        return true;
    }
//    public boolean checkUser(String account,String passwoed){
//        Cursor cursor = sqLiteDatabase.query("user",new String[]{"Gnum","Gpassword"},"Gnum=? and Gpassword=? and Gname=? ",new String[]{account,passwoed},null,null,null);
//        int count=cursor.getCount();
//        cursor.close();
//        return count>0;
//    }

}
