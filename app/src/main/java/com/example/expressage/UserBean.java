package com.example.expressage;

public class UserBean {
    // num, name, gender, phone, address
    private String num;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String address;

    public UserBean(String num,String password, String name, String gender,String phone,String address ){
        super();
        this.num=num;
        this.password=password;
        this.name=name;
        this.gender=gender;
        this.phone=phone;
        this.address=address;
    }

    public  String getnum(){
        return num;
    }
    public void setnum(String num){
        this.num=num;
    }
    public  String getpassword(){
        return password;
    }
    public void setpassword(String password){this.password=password;}
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address=address;
    }

    @Override
    public String toString() {
        return "";
    }

}