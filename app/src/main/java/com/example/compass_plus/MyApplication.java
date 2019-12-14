package com.example.compass_plus;

import android.app.Application;

public class MyApplication extends Application {
    private Guide currentUser;

    public Guide getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Guide currentUser) {
        this.currentUser = currentUser;
    }
}
