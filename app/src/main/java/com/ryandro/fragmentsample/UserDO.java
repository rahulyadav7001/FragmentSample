package com.ryandro.fragmentsample;

import java.io.Serializable;

public class UserDO implements Serializable {
    private String userName = "";
    private String userId = "";
    private String userLastName = "";
    private String gender = "";

    public UserDO(String userName, String userId, String userLastName, String gender) {
        this.userName = userName;
        this.userId = userId;
        this.userLastName = userLastName;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
