package com.example.expressage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class customer_edit extends AppCompatActivity {
    edit_Dao edit_Dao;
     String ID;
     String Type;
     String sendNum;
     String finishNum;
     String Content;
    float Grade1;
    float Grade2;
    float Grade3;
    private RatingBar ratingBar;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;
    float source1;
    float source2;
    float source3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_edit_comment);

        edit_Dao = new edit_Dao(this);
        Intent intent=getIntent();
//        sendNum=intent.getStringExtra("sendNum");
//        finishNum=intent.getStringExtra("finishNum");
//        Type=intent.getStringExtra("Type");



        ratingBar=findViewById(R.id.ratingbar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float point=(int) ((v/ratingBar.getNumStars())*100);
                source1=point;
                Toast.makeText(customer_edit.this,
                        "您的满意度为："+String.valueOf(point)+"%",Toast.LENGTH_SHORT).show(); //String.valueOf(float f) : 将 float 变量 f 转换成字符串
            }
        });
        ratingBar2=findViewById(R.id.ratingba2r);
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float point=(int) ((v/ratingBar.getNumStars())*100);
                source2=point;
                Toast.makeText(customer_edit.this,
                        "您的满意度为："+String.valueOf(point)+"%",Toast.LENGTH_SHORT).show(); //String.valueOf(float f) : 将 float 变量 f 转换成字符串
            }
        });
        ratingBar3=findViewById(R.id.ratingba3r);
        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float point=(int) ((v/ratingBar.getNumStars())*100);
                source3=point;
                Toast.makeText(customer_edit.this,
                        "您的满意度为："+String.valueOf(point)+"%",Toast.LENGTH_SHORT).show(); //String.valueOf(float f) : 将 float 变量 f 转换成字符串
            }
        });

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btn_submit=findViewById(R.id.button);
        EditText comment = findViewById(R.id.comment);
        comment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    comment.setText("");
                }
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                Grade1=source1;
                Grade2=source2;
                Grade3=source3;
                Content=comment.getText().toString();

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

                boolean result= edit_Dao.insertEdit( Type,  sendNum,  finishNum,  Content,  Grade1, Grade2, Grade3);
                if(result){
                    Toast.makeText(customer_edit.this, "完成:>", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(customer_edit.this, "失败...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
