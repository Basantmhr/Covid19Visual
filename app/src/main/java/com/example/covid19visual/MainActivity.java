package com.example.covid19visual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.example.covid19visual.UI.dashboard;
import com.example.covid19visual.UI.visual_activity;
import com.example.covid19visual.data.AsyncGetDataCompleted;
import com.example.covid19visual.data.JsonPlaceHolder;
import com.example.covid19visual.model.BedPer10Thousand;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I = new Intent(MainActivity.this, dashboard.class);
                startActivity(I);
                finish();
            }
        },2000);

    }
}
