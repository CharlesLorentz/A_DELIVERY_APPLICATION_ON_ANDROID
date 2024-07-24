package com.example.expressage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class company extends AppCompatActivity {

    String num;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company);


        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent user_num = getIntent();
        num = user_num.getStringExtra("num");
        ImageButton my_info=findViewById(R.id.btn_self_info);
        my_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(company.this, self_info.class);
                intent.putExtra("num",num);
                intent.putExtra("identity","company");
                startActivity(intent);
            }
        });

        Button btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(company.this, company_add.class);
                intent.putExtra("num",num);
                intent.putExtra("identity","company");
                startActivity(intent);
            }
        });
    }
}

