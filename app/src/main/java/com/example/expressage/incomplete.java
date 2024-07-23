package com.example.expressage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class incomplete  extends AppCompatActivity {
    String Self_info;
    courier_finish_Dao courier_finish_dao;
    SQLiteHelper sqLiteHelper;
     String Send_info;
     String Get_info;
     String Name;
     String Phone;
     String State;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        Self_info = intent.getStringExtra("Self_info");

        sqLiteHelper = new SQLiteHelper(this);

        setContentView(R.layout.incomplete);
        ImageButton back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView self_info = findViewById(R.id.show);
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
        courier_finish_dao=new courier_finish_Dao(this);
        Button submit=findViewById(R.id.submit);
        EditText send_info = findViewById(R.id.send_info);
        EditText get_info = findViewById(R.id.get_info);
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);

        CheckBox finish = findViewById(R.id.finish);
        boolean finish_check=finish.isChecked();
        String finish_text=finish.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send_info=send_info.getText().toString();
                Get_info=get_info.getText().toString();
                Name=name.getText().toString();
                Phone=phone.getText().toString();
                State=finish_text;


                boolean result= courier_finish_dao.insertUser(Send_info,Get_info,Name,Phone,State);
                if(result){
                    Toast.makeText(incomplete.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(incomplete.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
