package com.example.expressage;

public class edit_Bean {
    // ID Type sendNum finishNum Content Grade1 Grade2 Grade3
    private String ID;
    private String Type;
    private String sendNum;
    private String finishNum;
    private String Content;
    private String Grade1;
    private String Grade2;
    private String Grade3;

    public edit_Bean(String ID, String Type, String sendNum, String finishNum, String Content, String Grade1,String Grade2,String Grade3 ){
        super();
        this.ID=ID;
        this.Type=Type;
        this.sendNum=sendNum;
        this.finishNum=finishNum;
        this.Content=Content;
        this.Grade1=Grade1;
        this.Grade2=Grade2;
        this.Grade3=Grade3;

    }



    public  String ID(){
        return ID;
    }
    public void ID(String ID){
        this.ID=ID;
    }
    public  String Type(){
        return Type;
    }
    public void Type(String Type){this.Type=Type;}
    public String sendNum() {
        return sendNum;
    }

    public void sendNum(String sendNum) {
        this.sendNum = sendNum;
    }

    public String finishNum() {
        return finishNum;
    }

    public void finishNum(String finishNum) {
        this.finishNum = finishNum;
    }

    public String Content() {
        return Content;
    }

    public void Content(String Content) {
        this.Content = Content;
    }

    public String Grade1() {
        return Grade1;
    }

    public void Grade1(String Grade1) {
        this.Grade1=Grade1;
    }
    public String Grade2() {
        return Grade2;
    }

    public void Grade2(String Grade2) {
        this.Grade2=Grade2;
    }
    public String Grade3() {
        return Grade3;
    }

    public void Grade3(String Grade3) {
        this.Grade3=Grade3;
    }

    @Override
    public String toString() {
        return "";
    }
}
