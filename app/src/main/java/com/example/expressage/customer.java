package com.example.expressage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class customer extends AppCompatActivity {
    String num;
    String Self_info;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.customer);

        Intent intent=getIntent();
        num = intent.getStringExtra("num");
        Self_info = intent.getStringExtra("Self_info");

        sqLiteHelper = new SQLiteHelper(this);


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
                intent.setClass(customer.this, self_info.class);
                intent.putExtra("num",num);
                intent.putExtra("identity","customer");
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
