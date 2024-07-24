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

        Button self_info=findViewById(R.id.self_info);
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

        TextView parcel_info = findViewById(R.id.parcel_info);
        StringBuilder sb = new StringBuilder();

        SQLiteDatabase kdb =sqLiteHelper.getReadableDatabase();
        String sql = "select * from send ";
        Cursor cursor = kdb.rawQuery(sql,null);
        if(cursor != null && cursor.moveToFirst()){
            cursor.getColumnIndex("NDNum");
//            String Num = cursor.getString(cursor.getColumnIndex("Num"));
            String Get_name = cursor.getString(cursor.getColumnIndex("Sname"));
            String Get_phone = cursor.getString(cursor.getColumnIndex("Sphone"));
            String Sadress = cursor.getString(cursor.getColumnIndex("Sadress"));
            String Hname = cursor.getString(cursor.getColumnIndex("Hname"));
            String Cname = cursor.getString(cursor.getColumnIndex("Cname"));
            sb.append("收件人姓名: ").append(Get_name).append("\n")
                    .append("收件人电话: ").append(Get_phone).append("\n")
                    .append("收件人地址: ").append(Sadress).append("\n")
                    .append("货物名称: ").append(Hname).append("\n")
                    .append("物流公司").append(Cname).append("\n") ;

            parcel_info.setText(sb.toString());
        }
    }
}
