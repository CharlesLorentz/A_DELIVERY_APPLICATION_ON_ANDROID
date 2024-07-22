package com.example.expressage;

public class customer_send_Bean {
    private String Gnum;
    private String Send_info;
    private String Get_info;
    private String Sserver;
    private String Sway;
    public customer_send_Bean(String Send_info, String Get_info, String Sserver,String Sway ){
        super();

        this.Send_info=Send_info;
        this.Get_info=Get_info;
        this.Sserver=Sserver;
        this.Sway=Sway;

    }
    public  String getGnum(){
        return Gnum;
    }
    public void setGnum(String Gnum){
        this.Gnum=Gnum;
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

    public String getSserver() {
        return Sserver;
    }

    public void setSserver(String Sserver) {
        this.Sserver = Sserver;
    }

    public String getSway() {
        return Sway;
    }

    public void setSway(String Sway) {
        this.Sway = Sway;
    }
    @Override
    public String toString() {
        return "";
    }
}
