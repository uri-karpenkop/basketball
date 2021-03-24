package com.example.basketballtrain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {
    Button  btnShooting, btnDefensing, btnDriblling, btnStatistic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnShooting = (Button) findViewById(R.id.btnShooting);
        btnShooting.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnShooting){
                    startActivity(new Intent(HomePageActivity.this, ShootingActivity.class));
                }
            }

        });

        btnDefensing = (Button) findViewById(R.id.btnDefensing);
        btnDefensing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnDefensing){
                    startActivity(new Intent(HomePageActivity.this, DefensingActivity.class));

                }
            }

        });
        btnDriblling = (Button) findViewById(R.id.btnDriblling);
        btnDriblling.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnDriblling){
                    startActivity(new Intent(HomePageActivity.this, DribellingActivity.class));

                }
            }

        });

        btnStatistic = (Button) findViewById(R.id.btnStatistic);
        btnStatistic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnStatistic){
                    startActivity(new Intent(HomePageActivity.this, StatisticActivity.class));

                }
            }

        });
    }

}


