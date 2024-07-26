package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class courier extends AppCompatActivity {
    String num;
    String Num;
    SQLiteHelper sqLiteHelper;
    customer_send_Dao dao;
    courier_finish_Dao Dao;
    String Get_name;
    String Get_phone;
    String Sadress;
    String Hname;
    String Cname;
    String state;

    String com_num ;
    String cus_name;
    String cus_phone;
    String cus_address;
    String com_name;
    String com_phone;
    String com_address;
    String finish_state;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        Num = intent.getStringExtra("num");
        dao = new customer_send_Dao(this);
        Dao=new courier_finish_Dao(this);
        sqLiteHelper = new SQLiteHelper(this);

        setContentView(R.layout.courier);
        ImageButton back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton self_info=findViewById(R.id.self_info);
        self_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(courier.this, self_info.class);
                intent.putExtra("num",Num);
                intent.putExtra("identity","courier");
                startActivity(intent);
            }
        });

        Button complete =findViewById(R.id.complete);
        Button complete2=findViewById(R.id.complete2);
        Button show=findViewById(R.id.show);
        Button show2=findViewById(R.id.show2);
        SQLiteDatabase kdb =sqLiteHelper.getReadableDatabase();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView deliver_info = findViewById(R.id.deliver_info);
                StringBuilder del_sb = new StringBuilder();


                String del_sql = "select * from send ";
                Cursor cursor = kdb.rawQuery(del_sql,null);
                if(cursor != null && cursor.moveToFirst()){
                    cursor.getColumnIndex("NDNum");
                    num = cursor.getString(cursor.getColumnIndex("num"));
                    Get_name = cursor.getString(cursor.getColumnIndex("Sname"));
                    Get_phone = cursor.getString(cursor.getColumnIndex("Sphone"));
                    Sadress = cursor.getString(cursor.getColumnIndex("Sadress"));
                    Hname = cursor.getString(cursor.getColumnIndex("Hname"));
                    Cname = cursor.getString(cursor.getColumnIndex("Cname"));
                    state = cursor.getString(cursor.getColumnIndex("state"));
                    del_sb.append("收件人姓名: ").append(Get_name).append("\n")
                            .append("收件人电话: ").append(Get_phone).append("\n")
                            .append("收件人地址: ").append(Sadress).append("\n")
                            .append("货物名称: ").append(Hname).append("\n")
                            .append("物流公司").append(Cname).append("\n")
                            .append("状态: ").append(state).append("\n");

                    deliver_info.setText(del_sb.toString());
                }
            }
        });

        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView send_info = findViewById(R.id.send_info);
                StringBuilder send_sb = new StringBuilder();
                String send_sql = "select * from finish";
                Cursor cursor = kdb.rawQuery(send_sql,null);
                if(cursor != null && cursor.moveToFirst()){
                        num = cursor.getString(cursor.getColumnIndex("num"));
                     com_num = cursor.getString(cursor.getColumnIndex("com_num"));
//                     cus_name = "";
//                     cus_phone = "";
//                     cus_address = "";
//                     com_name = "";
//                     com_phone = "";
//                     com_address = "";
//                     finish_state="";
//                    String search_cus_sql = "select * from user";

                    String search_cus_sql = "select * from user where num=? and identity=?";
                    cursor = kdb.rawQuery(search_cus_sql,new String[]{num,"customer"});
                    if(cursor.moveToFirst()==true){
                        cus_name = cursor.getString(cursor.getColumnIndex("name"));
                        cus_phone = cursor.getString(cursor.getColumnIndex("phone"));
                        cus_address = cursor.getString(cursor.getColumnIndex("address"));
                    }
                    String search_com_sql = "select * from user where num=? and identity=?";


//                    String search_com_sql = "select * from user ";
                    cursor = kdb.rawQuery(search_com_sql,new String[]{com_num,"company"});
                    if(cursor.moveToFirst()==true){
                        com_name = cursor.getString(cursor.getColumnIndex("name"));
                        com_phone = cursor.getString(cursor.getColumnIndex("phone"));
                        com_address = cursor.getString(cursor.getColumnIndex("address"));
                    }
                    String search_finish_sql= "select * from finish where num=? and identity=?";
                    cursor= kdb.rawQuery(search_finish_sql,new String[]{num,"customer"});
                    if(cursor.moveToFirst()){
                        finish_state=cursor.getString(cursor.getColumnIndex("state"));
                    }

                    send_sb.append("收件人姓名: ").append(cus_name).append("\n")
                            .append("收件人电话: ").append(cus_phone).append("\n")
                            .append("收件人地址: ").append(cus_address).append("\n")
                            .append("物流公司名: ").append(com_name).append("\n")
                            .append("物流公司联系方式: ").append(com_phone).append("\n")
                            .append("物流公司地址: ").append(com_address).append("\n")
                            .append("状态:").append(finish_state).append("\n");



                    send_info.setText(send_sb.toString());
                }

            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag=dao.updateUser(num,"customer");
                if(flag){
                    Toast.makeText(courier.this, "已送达", Toast.LENGTH_SHORT).show();
                }
            }
        });

        complete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag=Dao.updateUser(num,"customer");
                if(flag){
                    Toast.makeText(courier.this, "已派送", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
