package com.code.guides.httpclient.user;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 11:43
 * @description:
 */

public class User {
    private String userId;
    private String userName;
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
