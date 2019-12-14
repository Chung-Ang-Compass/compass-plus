package com.example.compass_plus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuideRegisterActivity extends AppCompatActivity {

    private String[] countries;
    private String[] kor_cities;
    private String[] usa_cities;
    private String[] themes;

    private Spinner country_spinner;
    private Spinner city_spinner;
    private Spinner theme_spinner;

    private ServiceApi service;
    private ProgressBar mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_register);

        mProgressView = (ProgressBar) findViewById(R.id.register_progress);
        service = RetrofitClient.getClient().create(ServiceApi.class);

        countries = getResources().getStringArray(R.array.country);
        kor_cities = getResources().getStringArray(R.array.kor_city);
        usa_cities = getResources().getStringArray(R.array.usa_city);
        themes = getResources().getStringArray(R.array.theme);

        final ArrayAdapter<String> country_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        final ArrayAdapter<String> kor_city_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kor_cities);
        final ArrayAdapter<String> usa_city_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, usa_cities);
        final ArrayAdapter<String> theme_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, themes);

        country_spinner = (Spinner)findViewById(R.id.country_select_spinner);
//        country_spinner.setText("국가 선택");
        country_spinner.setAdapter(country_adapter);

        city_spinner = (Spinner)findViewById(R.id.city_select_spinner);
//        city_spinner.setText("도시 선택");

        theme_spinner = (Spinner)findViewById(R.id.theme_select_spinner);
        theme_spinner.setAdapter(theme_adapter);

        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
                MyApplication myApp = (MyApplication) getApplication();
                Guide currentUser = myApp.getCurrentUser();

                currentUser.setCountry(countries[position]);

                switch(position){
                    case 0:
                        city_spinner.setAdapter(kor_city_adapter);
                        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                MyApplication myApp = (MyApplication) getApplication();
                                Guide currentUser = myApp.getCurrentUser();

                                currentUser.setCity(kor_cities[position]);

                                switch(position){
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    default :
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        //한국만 띄워주기 함수
                        break;
                    case 1:
                        // 중국
                        break;
                    case 2:
                        city_spinner.setAdapter(usa_city_adapter);
                        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                MyApplication myApp = (MyApplication) getApplication();
                                Guide currentUser = myApp.getCurrentUser();

                                currentUser.setCity(usa_cities[position]);

                                switch(position){
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    default :
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        // 미국
                        break;
                    case 3:
                        // 스위스
                        break;
                    default:
                        // 전부다
                }
                Toast.makeText(getApplicationContext(), countries[position] + "가 선택되었습니다.", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
                // 전부다
            }
        });


        theme_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MyApplication myApp = (MyApplication) getApplication();
                Guide currentUser = myApp.getCurrentUser();

                currentUser.setTheme(themes[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.register_guide).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MyApplication myApp = (MyApplication) getApplication();
                Guide currentUser = myApp.getCurrentUser();
                GuideRegisterData data = new GuideRegisterData(currentUser.getEmail(), currentUser.getCountry(), currentUser.getCity(), currentUser.getTheme());
                Log.v("KKT", "currentUser.getEmail() : "+currentUser.getEmail());

                showProgress(true);

                service.guideRegister(data).enqueue(new Callback<GuideRegisterResponse>() {
                    @Override
                    public void onResponse(Call<GuideRegisterResponse> call, Response<GuideRegisterResponse> response) {
                        GuideRegisterResponse result = response.body();
                        Toast.makeText(GuideRegisterActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                        showProgress(false);

                        if (result.getCode() == 200) {
                            Intent intent = new Intent(getApplicationContext(), GuideRegisterSuccessActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<GuideRegisterResponse> call, Throwable t) {
                        Toast.makeText(GuideRegisterActivity.this, "compass", Toast.LENGTH_SHORT).show();
                        Log.e("가이드 등록 에러 발생", t.getMessage());
                        showProgress(false);
                    }
                });
            }
        });

    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
