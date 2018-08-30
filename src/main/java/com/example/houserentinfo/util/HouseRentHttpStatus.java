package com.example.houserentinfo.util;

public enum  HouseRentHttpStatus{

    UNAUTHORIZED_USER(500,"用户名或密码错误!"),
    DISABLED_USER(500,"该账户已被冻结或核销!"),
    UNKNOWN_LOGIN_FAILED(500,"登录失败!");

    private final int value;
    private final String reasonPhrase;

    HouseRentHttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public String toString() {
        return "HouseRentHttpStatus{" +
                "value=" + value +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                '}';
    }
}
