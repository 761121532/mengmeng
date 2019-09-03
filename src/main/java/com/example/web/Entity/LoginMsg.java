package com.example.web.Entity;

public class LoginMsg {
    private int errcode;
    private String msg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginMsg{" +
                "errcode=" + errcode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
