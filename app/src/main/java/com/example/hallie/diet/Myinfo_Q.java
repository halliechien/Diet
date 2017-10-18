package com.example.hallie.diet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Myinfo_Q extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_q);
    }

    public void click_cancel(View view) {
        finish();
    }

    public void click_ok(View view) {
    }
}
