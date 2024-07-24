package com.example.expressage;

public class courier_finish_Bean {

    private String Fnum;
    private String num;
    private String identity;
    private String Dnum;
    private String Hname;
    public courier_finish_Bean(String Fnum, String num, String identity,String Dnum,String Hname ){
        super();

        this.Fnum=Fnum;
        this.num=num;
        this.identity=identity;
        this.Dnum=Dnum;
        this.Hname=Hname;

    }

    public  String getFnum(){
        return Fnum;
    }
    public void setFnum(String Fnum){this.Fnum=Fnum;}
    public String getnum() {
        return num;
    }

    public void setnum(String num) {
        this.num = num;
    }

    public String getidentity() {
        return identity;
    }

    public void setidentity(String identity) {
        this.identity = identity;
    }

    public String getDnum() {
        return Dnum;
    }

    public void setDnum(String Dnum) {
        this.Dnum = Dnum;
    }
    public String getHname() {
        return Hname;
    }

    public void setHname(String Hname) {
        this.Hname = Hname;
    }
    @Override
    public String toString() {
        return "";
    }
}
