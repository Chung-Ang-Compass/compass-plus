package com.example.compass_plus;

public class Guide extends User{
    private String country;
    private String city;
    private String theme;
    private String bailiwick;
    private String career;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBailiwick(String bailiwick) {
        this.bailiwick = bailiwick;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBailiwick() {
        return bailiwick;
    }

    public String getCareer() {
        return career;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getTheme() {
        return theme;
    }
}
