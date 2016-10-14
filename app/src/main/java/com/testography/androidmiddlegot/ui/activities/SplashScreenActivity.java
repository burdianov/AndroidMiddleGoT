package com.testography.androidmiddlegot.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.data.managers.DataManager;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private Button mGoToButton;
    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mDataManager = DataManager.getInstance();

        mGoToButton = (Button) findViewById(R.id.go_to_btn);

        mGoToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this,
                        MainActivity.class);

                ArrayList<String> testData = new ArrayList<>();
                testData.add("Vasilica");
                testData.add("Petrica");
                testData.add("Jorica");

                intent.putExtra("test", testData);
                startActivity(intent);
                finish();
            }
        });
    }
}
