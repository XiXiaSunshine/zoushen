package com.yang.zoushen.exception;

public class LoginException extends Exception {
    private String msg;

    public LoginException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
