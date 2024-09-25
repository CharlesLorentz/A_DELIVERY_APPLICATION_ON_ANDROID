package com.example.expressage;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class courier_watch extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courier_watch_comment);
        sqLiteHelper=new SQLiteHelper(this);

        ImageButton back=findViewById(R.id.btn_back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SQLiteDatabase sdb=sqLiteHelper.getReadableDatabase();
        LinearLayout ll=(LinearLayout) findViewById(R.id.ll);
        Cursor cursor= sdb.query("comment",null,null,null,null,null,null);


        while (cursor.moveToNext()){
            @SuppressLint("Range") String ID=cursor.getString(cursor.getColumnIndex("ID"));
            @SuppressLint("Range") String Type=cursor.getString(cursor.getColumnIndex("Type"));
            @SuppressLint("Range") String sendNum=cursor.getString(cursor.getColumnIndex("sendNum"));
            @SuppressLint("Range") String finishNum=cursor.getString(cursor.getColumnIndex("finishNum"));
            @SuppressLint("Range") String Content=cursor.getString(cursor.getColumnIndex("Content"));
            @SuppressLint("Range") String  Grade1=cursor.getString(cursor.getColumnIndex("Grade1"));
            @SuppressLint("Range") String Grade2=cursor.getString(cursor.getColumnIndex("Grade2"));
            @SuppressLint("Range") String Grade3=cursor.getString(cursor.getColumnIndex("Grade3"));

            TextView tv=new TextView(this);
            //2.把人物的信息设置为文本的内容
            tv.setText(ID+"\n"+"订单类别："+Type+"\n"+"快递单号："+sendNum+"\n"+"派送单号："+finishNum+"\n"+"评论内容："+Content+"\n"+"服务态度："+Grade1+"分"+"\n"+"沟通及时："+Grade2+"分"+"\n"+"送货速度："+Grade3+"分"+"\n");
            tv.setTextSize(18);
            //3.把TextView设置成线性布局的子节点
            ll.addView(tv);

//
        }
    }
}
