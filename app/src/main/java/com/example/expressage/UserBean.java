package com.example.expressage;

public class UserBean {
    // Gnum, Gname, Ggender, Gphone, Gaddress
    private String Gnum;
    private String Gpassword;
    private String Gname;
    private String Ggender;
    private String Gphone;
    private String Gaddress;

    public UserBean(String  Gnum,String Gpassword, String Gname, String Ggender,String Gphone,String Gaddress ){
        super();
        this.Gnum=Gnum;
        this.Gpassword=Gpassword;
        this.Gname=Gname;
        this.Ggender=Ggender;
        this.Gphone=Gphone;
        this.Gaddress=Gaddress;
    }

    public  String getGnum(){
        return Gnum;
    }
    public void setGnum(String Gnum){
        this.Gnum=Gnum;
    }
    public  String getGpassword(){
        return Gpassword;
    }
    public void setGpassword(String Gpassword){this.Gpassword=Gpassword;}
    public String getGname() {
        return Gname;
    }

    public void setGname(String Gname) {
        this.Gname = Gname;
    }

    public String getGgender() {
        return Ggender;
    }

    public void setGgender(String Ggender) {
        this.Ggender = Ggender;
    }

    public String getGphone() {
        return Gphone;
    }

    public void setGphone(String Gphone) {
        this.Gphone = Gphone;
    }

    public String getGaddress() {
        return Gaddress;
    }

    public void setGaddress(String Gaddress) {
        this.Gaddress=Gaddress;
    }

    @Override
    public String toString() {
        return "";
    }

}