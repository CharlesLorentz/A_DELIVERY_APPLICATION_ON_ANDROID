package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class company_add extends AppCompatActivity {
    SQLiteHelper sqLiteHelper;

    courier_finish_Dao courier_finish_dao;
    String num;
    String identity;
    String customer_num;
    String goods;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_add);

        sqLiteHelper=new SQLiteHelper(this);
        Intent company_info = getIntent();
        num = company_info.getStringExtra("num");
        identity = company_info.getStringExtra("identity");

        courier_finish_dao = new courier_finish_Dao(this);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText get_num = findViewById(R.id.get_num);
        EditText goods_edit = findViewById(R.id.goods);

        get_num.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_num.setText("");
                }
            }
        });

        goods_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    goods_edit.setText("");
                }
            }
        });

        Button btn_save=findViewById(R.id.save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                customer_num=get_num.getText().toString();
                goods=goods_edit.getText().toString();

                SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
                String sql="select * from user where num=? and identity=?";
                Cursor cursor=sdb.rawQuery(sql, new String[]{customer_num,"customer"});
                if(cursor.moveToFirst()==true){}
                else {
                    Toast.makeText(company_add.this, "用户不在本系统中", Toast.LENGTH_SHORT).show();
                }


                boolean result= courier_finish_dao.insertUser(customer_num,"customer",num,"company",goods);
                if(result){
                    Toast.makeText(company_add.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(company_add.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
