package com.example.expressage;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class search extends AppCompatActivity {
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        sqLiteHelper=new SQLiteHelper(this);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView search=findViewById(R.id.search);
        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    search.setText("");
                }
            }
        });
        TextView package_show=findViewById(R.id.package_show);

        Button search_buttom=findViewById(R.id.search_button);
        search_buttom.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                String sea=search.getText().toString();
                StringBuilder sb = new StringBuilder();
                SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
                String sql="select * from send where NDNum=?";
                Cursor cursor=sdb.rawQuery(sql,new String[]{sea});
                if(cursor.moveToFirst()){

                    sb.append("收件人姓名: ").append(cursor.getString(cursor.getColumnIndex("Sname"))).append("\n")
                            .append("收件人电话: ").append(cursor.getString(cursor.getColumnIndex("Sphone"))).append("\n")
                            .append("收件人地址: ").append(cursor.getString(cursor.getColumnIndex("Sadress"))).append("\n")
                            .append("货物名称: ").append(cursor.getString(cursor.getColumnIndex("Hname"))).append("\n")
                            .append("物流公司: ").append(cursor.getString(cursor.getColumnIndex("Cname"))).append("\n");

                    package_show.setText(sb.toString());
                }
            }
        });

    }

}