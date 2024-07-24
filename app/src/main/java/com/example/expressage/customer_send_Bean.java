package com.example.expressage;

public class customer_send_Bean {
    private String NDNum;
    private String num;
    private String identity;
    private String Sname;
    private String Sphone;
    private String Sadress;
    private String Hname;
    private String Cname;
    public customer_send_Bean(String NDNum, String num, String identity,String Sname,String Sphone,String Sadress,String Hname,String Cname ){
        super();

        this.NDNum=NDNum;
        this.num=num;
        this.identity=identity;
        this.Sname=Sname;
        this.Sphone=Sphone;
        this.Sadress=Sadress;
        this.Hname=Hname;
        this.Cname=Cname;

    }
    public  String getNDNum(){
        return NDNum;
    }
    public void setNDNum(String NDNum){
        this.NDNum=NDNum;
    }
    public  String getnum(){
        return num;
    }
    public void setnum(String num){this.num=num;}
    public String getidentity() {
        return identity;
    }

    public void setidentity(String identity) {
        this.identity = identity;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String Sphone) {
        this.Sphone = Sphone;
    }
    public String getSadress() {
        return Sadress;
    }

    public void setSadress(String Sadress) {
        this.Sadress = Sadress;
    }
    public String getHname() {
        return Hname;
    }

    public void setHname(String Hname) {
        this.Hname = Hname;
    }
    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    @Override
    public String toString() {
        return "";
    }
}
