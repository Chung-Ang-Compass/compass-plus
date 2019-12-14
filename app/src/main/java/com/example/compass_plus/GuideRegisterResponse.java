package com.example.compass_plus;

import com.google.gson.annotations.SerializedName;

public class GuideRegisterResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
