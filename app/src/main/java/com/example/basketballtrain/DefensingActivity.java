package com.example.basketballtrain;
import android.content.Intent;
import android.os.Bundle;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.workouts.DefensingWorkout;
import com.example.basketballtrain.workouts.ShootingWorkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DefensingActivity extends AppCompatActivity {

    Button btnBack , btnDone;
    TextView tvWarmUpDescription, tvWorkoutDescription;
    DefensingWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DefensingWorkoutHelper(this);
        setContentView(R.layout.activity_defensing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvWarmUpDescription = findViewById(R.id.tvWarmUpDescription);
        DefensingWorkout defensingWorkout = new DefensingWorkout();
        tvWarmUpDescription.setText(defensingWorkout.getWarmUpDescription());

        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
        tvWorkoutDescription.setText(defensingWorkout.getDescription());

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnBack) {
                    finish();
                }
            }

        });

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnDone) {
                    startActivityForResult(new Intent(DefensingActivity.this, DefensingSurvyActivity.class), 0);

                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Integer numberOfTenTimesFour = data.getIntExtra("numberOfTenTimesFour", 0);
        Log.d(this.getClass().getName(), "The number of three Shoots is " + numberOfTenTimesFour);

        Integer numberOfSlant = data.getIntExtra("numberOfSlant", 0);
        Log.d(this.getClass().getName(), "The number of paint shoots is " + numberOfSlant);

        Integer numberOfSquat = data.getIntExtra("numberOfSquat", 0);
        Log.d(this.getClass().getName(), "The number of free shoots is " + numberOfSquat);

        Integer numberOfLance = data.getIntExtra("numberOfLance", 0);
        Log.d(this.getClass().getName(), "The number of extension shoots is " + numberOfLance);

        // save to database

        DefensingWorkout defensingWorkout = new DefensingWorkout(numberOfTenTimesFour, numberOfSlant, numberOfSquat, numberOfLance);
        dbHelper.open();
        dbHelper.createDefensingWorkout(defensingWorkout);
        dbHelper.close();

        Log.i(this.getClass().getName(), "The id for the workout is: " + defensingWorkout.getId());
        finish();
    }

}