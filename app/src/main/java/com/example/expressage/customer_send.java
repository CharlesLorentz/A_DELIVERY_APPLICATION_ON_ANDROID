package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class customer_send extends AppCompatActivity {
    customer_send_Dao customer_send_dao;
    SQLiteHelper sqLiteHelper;
    String num;
    String Sname;
    String Sphone;
    String Sadress;
    String Hname;
    String Cname;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_send);

        Intent intent=getIntent();
        num=intent.getStringExtra("num");
        sqLiteHelper=new SQLiteHelper(this);
        customer_send_dao = new customer_send_Dao(this);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btn_save=findViewById(R.id.save);
        EditText get_name = findViewById(R.id.get_name);
        EditText get_phone = findViewById(R.id.get_phone);
        EditText get_adress = findViewById(R.id.get_adress);
        EditText get_goods = findViewById(R.id.goods);



        get_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_name.setText("");
                }
            }
        });
        get_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_phone.setText("");
                }
            }
        });
        get_adress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_adress.setText("");
                }
            }
        });
        get_goods.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_goods.setText("");
                }
            }
        });
        SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
        String sql="select * from user where identity=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{"company"});
        String[] data={"","","",""};
        if(cursor.moveToFirst()){
//        while(cursor.moveToNext()){
//            for(int i=0;i<4;i++){
                data[0]=cursor.getString(cursor.getColumnIndex("num")).toString();
               if( cursor.moveToNext())
                data[1]=cursor.getString(cursor.getColumnIndex("num")).toString();
               if( cursor.moveToNext())
                 data[2]=cursor.getString(cursor.getColumnIndex("num")).toString();
                if(cursor.moveToNext())
                data[3]=cursor.getString(cursor.getColumnIndex("num")).toString();


//                cursor.getColumnIndex("Cname");
//            }
//        }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_item);
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cname= data[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
//        spinner.performClick();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                Sname=get_name.getText().toString();
                Sphone=get_phone.getText().toString();
                Sadress=get_adress.getText().toString();
                Hname=get_goods.getText().toString();
//                if (send_self_check){
//                    Sserver=send_self_text;
//                }
//                else {
//                    Sserver=send_door_text;
//                }
//                if (send_there_check){
//                    Sway=send_there_text;
//                }
//                else {
//                    Sway=send_here_text;
//                }

                boolean result= customer_send_dao.insertUser(num,"customer",Sname,Sphone,Sadress,Hname,Cname);
                if(result){
                    Toast.makeText(customer_send.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(customer_send.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
