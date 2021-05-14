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
public class StatisticActivity extends AppCompatActivity {

    Button btnBack ;
    Button btnAllShooting , btnAllDribelling , btnAllDefensing , btnAllPushups, btnHighestRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnBack) {
                    finish();
                }
            }
        });

        btnAllShooting = (Button) findViewById(R.id.btnAllShooting);
        btnAllShooting.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnAllShooting) {
                    startActivity(new Intent(StatisticActivity.this, ShootingWorkoutListActivity.class));
                }
            }
        });

        btnAllDribelling = (Button) findViewById(R.id.btnAllDribeling);
        btnAllDribelling.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnAllDribelling) {
                    startActivity(new Intent(StatisticActivity.this, DribellingWorkoutListActivity.class));
                }
            }
        });

        btnAllDefensing = (Button) findViewById(R.id.btnAllDefensing);
        btnAllDefensing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnAllDefensing) {
                    startActivity(new Intent(StatisticActivity.this, DefensingWorkoutListActivity.class));
                }
            }
        });

        btnAllPushups = (Button) findViewById(R.id.btnAllPushups);
        btnAllPushups.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnAllPushups) {
                    startActivity(new Intent(StatisticActivity.this, PushupsWorkoutListActivity.class));
                }
            }
        });

        btnHighestRecords = (Button) findViewById(R.id.btnHighestRecords);
        btnHighestRecords.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnHighestRecords) {
                    startActivity(new Intent(StatisticActivity.this, HighestRecordsActivity.class));
                }
            }
        });
    }
}