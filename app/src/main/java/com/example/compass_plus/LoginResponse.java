package com.example.compass_plus;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("userPwd")
    private String userPwd;

    @SerializedName("userNick")
    private String userNick;

    @SerializedName("userName")
    private String userName;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPwd(){return userPwd;}

    public String getUserNick(){return userNick;}

    public String getUserName(){return userName;}
}
