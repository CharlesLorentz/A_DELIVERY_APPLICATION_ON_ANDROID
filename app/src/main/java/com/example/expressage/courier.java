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

import androidx.appcompat.app.AppCompatActivity;

public class courier extends AppCompatActivity {
    String num;
    SQLiteHelper sqLiteHelper;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        num = intent.getStringExtra("num");

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
                intent.putExtra("num",num);
                intent.putExtra("identity","courier");
                startActivity(intent);
            }
        });

        TextView deliver_info = findViewById(R.id.deliver_info);
        StringBuilder del_sb = new StringBuilder();

        SQLiteDatabase kdb =sqLiteHelper.getReadableDatabase();
        String del_sql = "select * from send ";
        Cursor cursor = kdb.rawQuery(del_sql,null);
        if(cursor != null && cursor.moveToFirst()){
            cursor.getColumnIndex("NDNum");
            String num = cursor.getString(cursor.getColumnIndex("num"));
            String Get_name = cursor.getString(cursor.getColumnIndex("Sname"));
            String Get_phone = cursor.getString(cursor.getColumnIndex("Sphone"));
            String Sadress = cursor.getString(cursor.getColumnIndex("Sadress"));
            String Hname = cursor.getString(cursor.getColumnIndex("Hname"));
            String Cname = cursor.getString(cursor.getColumnIndex("Cname"));
            String state = cursor.getString(cursor.getColumnIndex("state"));
            del_sb.append("收件人姓名: ").append(Get_name).append("\n")
                    .append("收件人电话: ").append(Get_phone).append("\n")
                    .append("收件人地址: ").append(Sadress).append("\n")
                    .append("货物名称: ").append(Hname).append("\n")
                    .append("物流公司").append(Cname).append("\n")
                    .append("状态: ").append(state).append("\n");

            deliver_info.setText(del_sb.toString());
        }

        TextView send_info = findViewById(R.id.send_info);
        StringBuilder send_sb = new StringBuilder();

        String send_sql = "select * from finish";
        cursor = kdb.rawQuery(send_sql,null);
        if(cursor != null && cursor.moveToFirst()){
            String num = cursor.getString(cursor.getColumnIndex("num"));
            String com_num = cursor.getString(cursor.getColumnIndex("com_num"));
            String cus_name = "";
            String cus_phone = "";
            String cus_address = "";
            String com_name = "";
            String com_phone = "";
            String com_address = "";

            String search_cus_sql = "select * from user where num=? and identity=?";
            cursor = kdb.rawQuery(search_cus_sql,new String[]{num,"customer"});
            if(cursor.moveToFirst()==true){
                cus_name = cursor.getString(cursor.getColumnIndex("name"));
                cus_phone = cursor.getString(cursor.getColumnIndex("phone"));
                cus_address = cursor.getString(cursor.getColumnIndex("address"));
            }

            String search_com_sql = "select * from user where num=? and identity=?";
            cursor = kdb.rawQuery(search_com_sql,new String[]{com_num,"company"});
            if(cursor.moveToFirst()==true){
                com_name = cursor.getString(cursor.getColumnIndex("name"));
                com_phone = cursor.getString(cursor.getColumnIndex("phone"));
                com_address = cursor.getString(cursor.getColumnIndex("address"));
            }

            send_sb.append("收件人姓名: ").append(cus_name).append("\n")
                    .append("收件人电话: ").append(cus_phone).append("\n")
                    .append("收件人地址: ").append(cus_address).append("\n")
                    .append("物流公司名: ").append(com_name).append("\n")
                    .append("物流公司联系方式: ").append(com_phone).append("\n")
                    .append("物流公司地址: ").append(com_address).append("\n");

            send_info.setText(send_sb.toString());
        }

    }
}
