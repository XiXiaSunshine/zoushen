package com.yang.zoushen.exception;

public class InsertUserException extends Exception {
    private static final long serialVersionUID = 1L;
    private String msg;

    public InsertUserException(String msg) {
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
