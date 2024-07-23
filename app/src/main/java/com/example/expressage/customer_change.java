package com.example.expressage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class customer_change extends AppCompatActivity {
    String num;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_change);
        userDao = new UserDao(this);
        Intent intent=getIntent();
        num = intent.getStringExtra("num");
        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText c_name=findViewById(R.id.c_name);
        EditText c_password=findViewById(R.id.c_password);
        EditText c_gender=findViewById(R.id.c_gender);
        EditText c_phone=findViewById(R.id.c_phone);
        EditText c_address=findViewById(R.id.c_address);

        Button finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean judge=userDao.updateUser(num,c_name.getText().toString(),c_password.getText().toString(),c_gender.getText().toString(),c_phone.getText().toString(),c_address.getText().toString());
                if(judge){
                    Toast.makeText(customer_change.this, " 修改成功:>", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(customer_change.this, "修改失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
