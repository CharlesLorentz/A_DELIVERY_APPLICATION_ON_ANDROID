package com.example.expressage;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class customer_self_info extends AppCompatActivity {
    String num;
    SQLiteHelper sqLiteHelper;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        num=intent.getStringExtra("Gnum");
//        Toast.makeText(this, num, Toast.LENGTH_SHORT).show();
        sqLiteHelper=new SQLiteHelper(this);

        setContentView(R.layout.customer_self_info);
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
        String sql="select * from user where Gnum=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{num});
        if(cursor.moveToFirst()==true){
            Number.setText("账号"+"  "+ cursor.getString(cursor.getColumnIndex("Gnum")));
            Password.setText("密码"+"  "+cursor.getString(cursor.getColumnIndex("Gpassword")));
            Name.setText(cursor.getString(cursor.getColumnIndex("Gname")));
            Gender.setText("性别"+"  "+cursor.getString(cursor.getColumnIndex("Ggender")));
            Phone.setText("电话"+"  "+cursor.getString(cursor.getColumnIndex("Gphone")));
            Address.setText("地址"+"  "+cursor.getString(cursor.getColumnIndex("Gaddress")));
        }
//        while (cursor.moveToNext()){
//            Name.setText(cursor.getString(cursor.getColumnIndex("Gname")));
//            Number.setText(cursor.getString(cursor.getColumnIndex("Gnumber")));
//            Password.setText(cursor.getString(cursor.getColumnIndex("Gpassword")));
//            Gender.setText(cursor.getString(cursor.getColumnIndex("Ggender")));
//            Phone.setText(cursor.getString(cursor.getColumnIndex("Gphone")));
//            Address.setText(cursor.getString(cursor.getColumnIndex("Gaddress")));
//
//        }

    }
}
