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
    String Self_info;
    SQLiteHelper sqLiteHelper;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        Self_info = intent.getStringExtra("Self_info");

        sqLiteHelper = new SQLiteHelper(this);

        setContentView(R.layout.courier);
        ImageButton back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button my_info=findViewById(R.id.my_info);
        my_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(courier.this, courier_self_info.class);
                startActivity(intent);
            }
        });
        TextView self_info = findViewById(R.id.self_info);
        StringBuilder sb = new StringBuilder();

        SQLiteDatabase kdb =sqLiteHelper.getReadableDatabase();
        String sql = "select * from send ";
        Cursor cursor = kdb.rawQuery(sql,null);
        if(cursor != null && cursor.moveToFirst()){
//                String num=cursor.getString(cursor.getColumnIndex("num"));
                String Send_info = cursor.getString(cursor.getColumnIndex("Send_info"));
                String Get_info = cursor.getString(cursor.getColumnIndex("Get_info"));
                String Sserver = cursor.getString(cursor.getColumnIndex("Sserver"));
                String Sway = cursor.getString(cursor.getColumnIndex("Sway"));
                sb.append("寄件人信息: ").append(Send_info).append("\n")
                    .append("收件人信息: ").append(Get_info).append("\n")
                    .append("服务类型: ").append(Sserver).append("\n")
                    .append("寄出方式: ").append(Sway).append("\n\n");

                self_info.setText(sb.toString());


        }

//        SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
//        String sql="select * from user where num=?";
//        Cursor cursor=sdb.rawQuery(sql, new String[]{num});
//        if(cursor.moveToFirst()==true){
//            Self_info.setText("收件人信息:"+cursor.getString(cursor.getColumnIndex("num")));
//        }
    }
}
