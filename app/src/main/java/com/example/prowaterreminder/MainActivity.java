package com.example.prowaterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); // tắt hiển thị tên app

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                changeActivity();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,1000);
    }

    public void changeActivity() {
        Intent intent = new Intent(MainActivity.this, SliderIntro.class);
        startActivity(intent);
        finish();
    }

}