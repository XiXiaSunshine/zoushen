package com.yang.zoushen.enums;

public enum SimpleMsgEnum {
    USER_CAN_BE_USED(true, "该用户名可以注册！"),
    REGIST_SUCCESS(true, "注册成功"),
    REGIST_ERROR(false, "注册失败！"),
    USER_ALREADY_EXISTS(false, "此用户已经存在！"),
    NOT_FOUND_USER(false, "查无此用户名！"),
    PASSWORD_ERROR(false, "密码错误！"),
    LOGIN_SUCCESS(true, "登录成功！"),
    CODE_ERROR(false, "验证码错误！"),
    CODE_SUCCESS(true, "验证码正确！")


    ;

    private SimpleMsgEnum(Boolean flag, String msg) {
        this(flag, msg, null);
    }

    private SimpleMsgEnum(Boolean flag, String msg, String url) {
        this.flag = flag;
        this.msg = msg;
        this.url = url;
    }

    private SimpleMsgEnum(){

    }
    private Boolean flag;
    private String msg;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
