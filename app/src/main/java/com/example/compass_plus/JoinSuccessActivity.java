package com.example.compass_plus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinSuccessActivity extends AppCompatActivity {
    private Button mSuccessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_join);
        mSuccessButton = (Button) findViewById(R.id.start_btn);

        mSuccessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GuideRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
