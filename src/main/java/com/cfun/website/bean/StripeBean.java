package com.cfun.website.bean;

public class StripeBean {
    //暂定三个参数，后面可以根据需要添加
    private String token;
    private Integer amount;
    private String  description;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
