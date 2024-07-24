package com.example.expressage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class customer_send extends AppCompatActivity {
    customer_send_Dao customer_send_dao;

    String Sname;
    String Sphone;
    String Sadress;
    String Hname;
    String Cname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_send);

        customer_send_dao = new customer_send_Dao(this);
        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btn_save=findViewById(R.id.save);
        EditText get_name = findViewById(R.id.get_name);
        EditText get_phone = findViewById(R.id.get_phone);
        EditText get_adress = findViewById(R.id.get_adress);
        EditText get_goods = findViewById(R.id.goods);
        EditText get_company = findViewById(R.id.company);


//        CheckBox send_self = findViewById(R.id.send_self);
//        boolean send_self_check=send_self.isChecked();
//        String send_self_text=send_self.getText().toString();

//        CheckBox send_door = findViewById(R.id.send_door);
//        boolean send_self_door=send_self.isChecked();
//        String send_door_text=send_door.getText().toString();
//
//        CheckBox send_there = findViewById(R.id.send_there);
//        boolean send_there_check=send_self.isChecked();
//        String send_there_text=send_there.getText().toString();
//
//        CheckBox send_here = findViewById(R.id.send_here);
//        boolean send_here_check=send_self.isChecked();
//        String send_here_text=send_here.getText().toString();

//        if (send_self_check){
//            Sserver=send_self_text;
//        }
//        else {
//            Sserver=send_door_text;
//        }
//        if (send_there_check){
//            Sway=send_there_text;
//        }
//        else {
//            Sway=send_here_text;
//        }
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sname=get_name.getText().toString();
                Sphone=get_name.getText().toString();
                Sadress=get_adress.getText().toString();
                Hname=get_goods.getText().toString();
                Cname=get_company.getText().toString();
//                if (send_self_check){
//                    Sserver=send_self_text;
//                }
//                else {
//                    Sserver=send_door_text;
//                }
//                if (send_there_check){
//                    Sway=send_there_text;
//                }
//                else {
//                    Sway=send_here_text;
//                }


                boolean result= customer_send_dao.insertUser(Sname,Sphone,Sadress,Hname,Cname);
                if(result){
                    Toast.makeText(customer_send.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(customer_send.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
