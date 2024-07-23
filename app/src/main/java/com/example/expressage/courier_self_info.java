package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class courier_self_info extends AppCompatActivity {
    String num;
    SQLiteHelper sqLiteHelper;
    @SuppressLint("range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        num=intent.getStringExtra("num");
        sqLiteHelper=new SQLiteHelper(this);
//
        setContentView(R.layout.courier_self_info);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView Name=findViewById(R.id.name);
        TextView Number=findViewById(R.id.number);
        TextView Password=findViewById(R.id.password);
        TextView Gender=findViewById(R.id.gender);
        TextView Phone=findViewById(R.id.phone);
        TextView Address=findViewById(R.id.address);

        SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
        String sql="select * from user ";
        Cursor cursor=sdb.rawQuery(sql, null);
        if(cursor.moveToFirst()==true){
            Number.setText("账号"+"  "+ cursor.getString(cursor.getColumnIndex("num")));
            Password.setText("密码"+"  "+cursor.getString(cursor.getColumnIndex("password")));
            Name.setText(cursor.getString(cursor.getColumnIndex("name")));
            Gender.setText("性别"+"  "+cursor.getString(cursor.getColumnIndex("gender")));
            Phone.setText("电话"+"  "+cursor.getString(cursor.getColumnIndex("phone")));
            Address.setText("地址"+"  "+cursor.getString(cursor.getColumnIndex("address")));
        }
    }
}
