package com.example.vishnusai.yamyaycodingtest;

/**
 * Created by Vishnu Sai on 03/28/2017.
 */

public class product {

    String pid;
    String pname;
    public product(){

    }

    public product(String pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public String getpname() {
        return pname;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
