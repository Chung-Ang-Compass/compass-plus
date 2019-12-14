package com.example.compass_plus;

import com.google.gson.annotations.SerializedName;

public class GuideRegisterData {

    @SerializedName("userEmail")
    String userEmail;

    @SerializedName("country")
    String country;

    @SerializedName("city")
    String city;

    @SerializedName("theme")
    String theme;

    public  GuideRegisterData(String userEmail, String country, String city, String theme) {
        this.userEmail = userEmail;
        this.country = country;
        this.city = city;
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
