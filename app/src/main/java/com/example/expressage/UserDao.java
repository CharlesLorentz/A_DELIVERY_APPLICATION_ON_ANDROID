package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * 数据库访问对象
 * DAO:DATA ACCESS OBJECT
 * 是控制层于数据库交互的中间层，用于做数据库的增删改查具体实现
 * */
//public class UserDao extends BaseDao {
 public class UserDao {

    private SQLiteDatabase sqLiteDatabase;
    //SQLiteDatabase对象封装了所有SQLite的增删改查语句的操作方法，让开发者直接调用就行

    public UserDao(Context context){
//    public UserDao(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version){
//        super(context, name, factory, version);
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        //获取sqLiteDatabase对象
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
    }

    /**
     * 插入一条记录进入user表
     * insert into user("username","password") values("zhangsan","123456");
     * */
    public boolean insertUser(String num, String identity, String password, String name, String gender, String phone, String address){
        ContentValues values = new ContentValues();
        values.put("num", num);
        values.put("identity", identity);
        values.put("password", password);
        values.put("name", name);
        values.put("gender", gender);
        values.put("phone", phone);
        values.put("address", address);

        //第一个是表名，第二个null，第三个是相当于sql插入语句的values
        //id用于判断是否插入成功： 如果大于0则表示插入了至少一条数据，否则插入失败
        long id = sqLiteDatabase.insert("user",null, values);

        return id>0?true:false;
    }

    /**
     * 查询记录
     * select * from user where username = "zhangsan";
     * */
    @SuppressLint("Range")
    public UserBean querryUser(String num, String identity,String password, String name, String gender, String phone, String address){

        Cursor cursor = sqLiteDatabase.query("user",new String[]{"num","password","name","gender","phone","address"},"num=? and password=? and name=? and gender=?and phone=?and address=?",new String[]{num,password,name,gender,phone,address},null,null,null);

        UserBean userBean = new UserBean(num,password,name,gender,phone,address);
        while (cursor.moveToNext()){
            userBean.setnum(cursor.getString(cursor.getColumnIndex("num")));
            userBean.setpassword(cursor.getString(cursor.getColumnIndex("password")));
            userBean.setname(cursor.getString(cursor.getColumnIndex("name")));
            userBean.setgender(cursor.getString(cursor.getColumnIndex("gender")));
            userBean.setphone(cursor.getString(cursor.getColumnIndex("phone")));
            userBean.setaddress(cursor.getString(cursor.getColumnIndex("address")));

//            Log.e("tag", userBean.getGnum() + "|" + userBean.getGname() + "|" + userBean.getGgender() + "|" + userBean.getGphone() + "|" + userBean.getGaddress());

        }
        cursor.close();
        return userBean;
    }

    public boolean checkUser(String account,String password){
        Cursor cursor = sqLiteDatabase.query("user",new String[]{"num","password"},"num=? and password=? and name=? ",new String[]{account,password},null,null,null);
        int count=cursor.getCount();
        cursor.close();
        return count>0;
    }

    /**
     * 修改数据库表记录
     * update user set password = 123123 where username = zhangsan
     * */
    public boolean updateUser(String longitude, String latitude, String country, String province, String city, String county, String street, String hnumber, String bump){

//        ContentValues values = new ContentValues();
//        values.put("password",newpassword);
//        long id = sqLiteDatabase.update("user",values,"username = ? ",new String[]{username});
//        flag = id > 0?true : false;
        return true;
    }



    /**
     * 删除
     * delete from user where username = "xxx"
     * */
    public boolean deleteUser(){
        sqLiteDatabase.delete("user", null, null);
        //        long id = sqLiteDatabase.delete("user","username = ?",new String[]{username});
        return true;
    }
}
