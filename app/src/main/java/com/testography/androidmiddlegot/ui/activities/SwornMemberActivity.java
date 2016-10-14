package com.testography.androidmiddlegot.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.testography.androidmiddlegot.R;

public class SwornMemberActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sworn_member);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        mTextView = (TextView) findViewById(R.id.text_view_profile);

        Intent intent = getIntent();
        String message = intent.getStringExtra("name");
        mTextView.setText(message);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
