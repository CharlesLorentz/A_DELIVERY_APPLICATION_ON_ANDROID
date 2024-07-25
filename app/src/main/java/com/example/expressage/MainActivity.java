package com.example.expressage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.nio.channels.SelectableChannel;


public class MainActivity extends AppCompatActivity{

    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sqLiteHelper=new SQLiteHelper(this);


        CheckBox btn_company=findViewById(R.id.btn_company);
        CheckBox btn_courier=findViewById(R.id.btn_courier);
        CheckBox btn_customer=findViewById(R.id.btn_customer);

        Button btn_login=findViewById(R.id.btn_login);
        EditText account_edit=findViewById(R.id.editTextTextPassword);
        account_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        EditText password_edit=findViewById(R.id.editTextTextPassword2);




        btn_customer.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                btn_courier.setChecked(false);
                btn_company.setChecked(false);
            }
        });

        btn_courier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_customer.setChecked(false);
                btn_company.setChecked(false);
            }
        });

        btn_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_courier.setChecked(false);
                btn_customer.setChecked(false);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=account_edit.getText().toString();
                String password=password_edit.getText().toString();

                String identity = "";
                if (btn_company.isChecked()) identity = "company";
                if (btn_courier.isChecked()) identity = "courier";
                if (btn_customer.isChecked()) identity = "customer";
                if(!btn_company.isChecked()&&!btn_customer.isChecked()&&!btn_courier.isChecked()){
                    Toast.makeText(MainActivity.this, "请选择一个登入身份", Toast.LENGTH_SHORT).show();
                    return;
                }

//                boolean flag=userDao.checkUser(acc,pas);
//                if(flag) {
                SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
                String sql="select * from user where num=? and identity=? and password=?";
                Cursor cursor=sdb.rawQuery(sql, new String[]{num,identity,password});
                if(cursor.moveToFirst()==true){

                    //company
                    if (btn_company.isChecked()) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, company.class);
                        intent.putExtra("num",num);
                        startActivity(intent);
                    }
                    //courier
                    if (btn_courier.isChecked()) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, courier.class);
                        intent.putExtra("num",num);
                        startActivity(intent);
                    }
                    //customer
                    if (btn_customer.isChecked()) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, customer.class);
                        intent.putExtra("num",num);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }

//                }else{
//                    Toast.makeText(MainActivity.this, acc+pas, Toast.LENGTH_SHORT).show();
//                }

            }
        });
        Button btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, register.class);
                if (btn_company.isChecked()){
                    intent.putExtra("identity","company");
                    startActivity(intent);
                }
                if (btn_courier.isChecked()){
                    intent.putExtra("identity","courier");
                    startActivity(intent);
                }
                if (btn_customer.isChecked()){
                    intent.putExtra("identity","customer");
                    startActivity(intent);
                }
                if(!btn_company.isChecked()&&!btn_customer.isChecked()&&!btn_courier.isChecked()){
                    Toast.makeText(MainActivity.this, "请选择一个注册身份", Toast.LENGTH_SHORT).show();
                }
            }
        });


//删除数据库

//            Context context = getApplicationContext();
//            String databasePath = context.getDatabasePath("user.db").getPath();
//
//
//            SQLiteDatabase database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
//            database.close();
//
//
//            File databaseFile = new File(databasePath);
//            if (databaseFile.exists()) {
//                boolean deleted = databaseFile.delete();
//                if (deleted) {
//                    System.out.println("成功删除");
//                } else {
//                    System.out.println("成功删除");
//                }
//            } else {
//                System.out.println("不存在");
//            }




    }



}