package com.example.expressage;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
public class customer_self_info extends AppCompatActivity {
    String num;
    SQLiteHelper sqLiteHelper;
    UserDao userDao;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        userDao = new UserDao(this);
        num=intent.getStringExtra("num");
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
        String sql="select * from user where num=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{num});
        if(cursor.moveToFirst()==true){
            Number.setText("账号"+"  "+ cursor.getString(cursor.getColumnIndex("num")));
            Password.setText("密码"+"  "+cursor.getString(cursor.getColumnIndex("password")));
            cursor.getString(cursor.getColumnIndex("identity"));
            Name.setText(cursor.getString(cursor.getColumnIndex("name")));
            Gender.setText("性别"+"  "+cursor.getString(cursor.getColumnIndex("gender")));
            Phone.setText("电话"+"  "+cursor.getString(cursor.getColumnIndex("phone")));
            Address.setText("地址"+"  "+cursor.getString(cursor.getColumnIndex("address")));
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
        Button change=findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(customer_self_info.this, customer_change.class);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        Button delete=findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog=new AlertDialog.Builder(customer_self_info.this);
//设置对话框
                dialog.setTitle("注销账户");
                dialog.setMessage("确认注销请点击确定");
                dialog.setIcon(R.mipmap.ic_launcher);


//设置按钮
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Boolean confirm=userDao.deleteUser(num);
                        if(confirm){
                            Toast.makeText(customer_self_info.this, "注销成功", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent();
                            intent.setClass(customer_self_info.this,MainActivity.class);
                            startActivity(intent);

                        }
                        else{finish();}
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(customer_self_info.this, "谢谢您的回心转意", Toast.LENGTH_SHORT).show();
                    }
                });
//显示对话框
                dialog.show();
            }
        });
    }
}
