package com.example.expressage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class customer extends AppCompatActivity {
    String Gnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);

        Intent intent=getIntent();
        Gnum = intent.getStringExtra("Gnum");


        ImageButton back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton my_info=findViewById(R.id.btn_user);
        my_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(customer.this, customer_self_info.class);
                intent.putExtra("Gnum",Gnum);
                startActivity(intent);
            }
        });
        ImageButton send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(customer.this, customer_send.class);
                startActivity(intent);
            }
        });
        ImageButton search = findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(customer.this, search.class);
                startActivity(intent);
            }
        });

    }
}
