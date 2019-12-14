package com.example.compass_plus;

//import com.example.compass.JoinData;
//import com.example.compass.JoinResponse;
//import com.example.compass.LoginData;
//import com.example.compass.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
        @POST("/guide/login")
        Call<LoginResponse> userLogin(@Body LoginData data);

        @POST("/guide/join")
        Call<JoinResponse> userJoin(@Body JoinData data);

        @POST("/guide/register")
        Call<GuideRegisterResponse> guideRegister(@Body GuideRegisterData data);
}
