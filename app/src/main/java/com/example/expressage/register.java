package com.example.expressage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    customerDao customerDao;
    String num;
    String password;
    String name;
    String gender;
    String phone;
    String address;
    String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

//        userDao = new UserDao(this, "login.db", null, 1);
        customerDao = new customerDao(this);
        Intent identity_intent = getIntent();
        identity = identity_intent.getStringExtra("identity");

        Button btn_back=findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean flag;
//                flag=userDao.deleteUser();
//                if(flag){
//                    Toast.makeText(register.this, "删除成功:>", Toast.LENGTH_SHORT).show();
//                }





                finish();
            }
        });



        Button btn_save=findViewById(R.id.btn_save);
        EditText password_edit = findViewById(R.id.Gpassword_content);
        EditText confirm_edit = findViewById(R.id.confirm_content);
        EditText num_edit = findViewById(R.id.Gnum_content);
        EditText name_edit = findViewById(R.id.Gname_content);
        EditText gender_edit = findViewById(R.id.Ggender_content);
        EditText phone_edit = findViewById(R.id.Gphone_content);
        EditText address_edit = findViewById(R.id.Gaddress_content);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=num_edit.getText().toString();
                password=password_edit.getText().toString();
                name=name_edit.getText().toString();
                gender=gender_edit.getText().toString();
                phone=phone_edit.getText().toString();
                address=address_edit.getText().toString();

//                Toast.makeText(register.this, password.getText().getClass().toString(), Toast.LENGTH_SHORT).show();
                if(password_edit.getText().toString().equals(confirm_edit.getText().toString())){
                    boolean result = customerDao.insertUser(num, identity, password, name, gender, phone, address);
                    if(result){
                        Toast.makeText(register.this, "注册成功:>", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(register.this, "账号重复...", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
//                if(password.getText() != confirm.getText()){
                    Toast.makeText(register.this, "密码与确认密码的内容不同 请重新输入:>", Toast.LENGTH_SHORT).show();
                }

//
            }
        });
    }

}