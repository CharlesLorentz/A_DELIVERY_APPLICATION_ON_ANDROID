package com.example.expressage;

public class courier_finish_Bean {

    private String Send_info;
    private String Get_info;
    private String name;
    private String phone;
    private String state;
    public courier_finish_Bean(String Send_info, String Get_info, String name,String phone,String state ){
        super();

        this.Send_info=Send_info;
        this.Get_info=Get_info;
        this.name=name;
        this.phone=phone;
        this.state=state;

    }

    public  String getSend_info(){
        return Send_info;
    }
    public void setSend_info(String Send_info){this.Send_info=Send_info;}
    public String getGet_info() {
        return Get_info;
    }

    public void setGet_info(String Get_info) {
        this.Get_info = Get_info;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }
    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "";
    }
}
