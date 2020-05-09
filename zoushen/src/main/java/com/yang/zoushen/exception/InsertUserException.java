package com.yang.zoushen.exception;

public class InsertUserException extends Exception {
    private String msg;
    public InsertUserException(String msg){
        this.msg = msg;
    }
}
