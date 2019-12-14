package com.example.compass_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class GuideRegisterSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_register_success);

        // 다시 로그인 화면으로
        MyApplication myApp = (MyApplication) getApplication();
        myApp.setCurrentUser(null);

        Handler timer = new Handler(); //Handler 생성

        timer.postDelayed(new Runnable(){

            public void run(){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }

        }, 2000); //2000은 2초를 의미한다.

    }
}