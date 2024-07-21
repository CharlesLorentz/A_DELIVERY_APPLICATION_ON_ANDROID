package com.example.expressage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    UserDao userDao;
    String Gnum;
    String Gpassword;
    String Gname;
    String Ggender;
    String Gphone;
    String Gaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

//        userDao = new UserDao(this, "login.db", null, 1);
        userDao = new UserDao(this);



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
        EditText password = findViewById(R.id.Gpassword_content);
        EditText confirm = findViewById(R.id.confirm_content);
        EditText num = findViewById(R.id.Gnum_content);
        EditText name = findViewById(R.id.Gname_content);
        EditText gender = findViewById(R.id.Ggender_content);
        EditText phone = findViewById(R.id.Gphone_content);
        EditText address = findViewById(R.id.Gaddress_content);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gnum=num.getText().toString();
                Gpassword=password.getText().toString();
                Gname=name.getText().toString();
                Ggender=gender.getText().toString();
                Gphone=phone.getText().toString();
                Gaddress=address.getText().toString();

//                Toast.makeText(register.this, password.getText().getClass().toString(), Toast.LENGTH_SHORT).show();
                if(password.getText().toString().equals(confirm.getText().toString())){
                    boolean result = userDao.insertUser(Gnum,Gpassword,Gname,Ggender,Gphone,Gaddress);
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