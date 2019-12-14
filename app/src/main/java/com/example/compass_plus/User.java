package com.example.compass_plus;

public class User {
    private String email;
    private String pwd;
    private String userNick;
    private String userName;

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
