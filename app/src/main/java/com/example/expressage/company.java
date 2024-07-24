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

public class company extends AppCompatActivity {


    SQLiteHelper sqLiteHelper;

    courier_finish_Dao courier_finish_dao;
    String customer_num;
    String goods;

    String my_num;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company);
        sqLiteHelper=new SQLiteHelper(this);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent user_num = getIntent();
        my_num = user_num.getStringExtra("num");
        ImageButton my_info=findViewById(R.id.btn_self_info);
        my_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(company.this, self_info.class);
                intent.putExtra("num",my_num);
                intent.putExtra("identity","company");
                startActivity(intent);
            }
        });

        courier_finish_dao = new courier_finish_Dao(this);

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
                    Toast.makeText(company.this, "用户不在本系统中", Toast.LENGTH_SHORT).show();
                }


                boolean result= courier_finish_dao.insertUser(customer_num,"customer",my_num,"company",goods);
                if(result){
                    Toast.makeText(company.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(company.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

