package com.example.basketballtrain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.db.PushupsWorkoutHelper;
import com.example.basketballtrain.workouts.DefensingWorkout;
import com.example.basketballtrain.workouts.PushupWorkout;

public class PushupsActivity extends AppCompatActivity {

    Button btnBack, btnStart;
    TextView tvWorkoutDescription;
    PushupsWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new PushupsWorkoutHelper(this);
        setContentView(R.layout.activity_pushups);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PushupWorkout pushupWorkout = new PushupWorkout();

        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
        tvWorkoutDescription.setText(pushupWorkout.getDescription());

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnBack) {
                    finish();
                }
            }

        });

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnStart) {
                   // start timer

                    startActivityForResult(new Intent(PushupsActivity.this, PushupsSurvyActivity.class), 0);

                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Integer numOfPushups = data.getIntExtra("numOfPushups", 0);
        Log.d(this.getClass().getName(), "The number of pushups is " + numOfPushups);


        // save to database

        PushupWorkout pushupWorkout = new PushupWorkout(numOfPushups);
        dbHelper.open();
        dbHelper.createPushupsWorkout(pushupWorkout);
        dbHelper.close();

        Log.i(this.getClass().getName(), "The id for the workout is: " + pushupWorkout.getId());
        finish();
    }
}