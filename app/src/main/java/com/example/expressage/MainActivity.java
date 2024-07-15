package com.example.expressage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CheckBox btn_company=findViewById(R.id.btn_company);
        CheckBox btn_courier=findViewById(R.id.btn_courier);
        CheckBox btn_customer=findViewById(R.id.btn_customer);

        Button btn_login=findViewById(R.id.btn_login);

        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_courier.setChecked(false);
                btn_company.setChecked(false);
            }
        });

        btn_courier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_customer.setChecked(false);
                btn_company.setChecked(false);
            }
        });

        btn_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_courier.setChecked(false);
                btn_customer.setChecked(false);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //company
                if(btn_company.isChecked()) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, customer.class);
                    startActivity(intent);
                }
                //courier
                if(btn_courier.isChecked()){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, courier.class);
                    startActivity(intent);
                }
                //customer
                if(btn_customer.isChecked()){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, company.class);
                    startActivity(intent);
                }
                if(!btn_company.isChecked()&&!btn_customer.isChecked()&&!btn_courier.isChecked()){
                    Toast.makeText(MainActivity.this, "请选择一个登入身份", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, register.class);
                startActivity(intent);
            }
        });
    }



}