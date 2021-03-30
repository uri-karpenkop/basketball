package com.example.basketballtrain;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.workouts.DefensingWorkout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DefensingActivity extends AppCompatActivity {

    Button btnBack, btnDone;
    TextView tvWarmUpDescription, tvWorkoutDescription;
    DefensingWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DefensingWorkoutHelper(this);
        setContentView(R.layout.activity_defensing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        tvWarmUpDescription = findViewById(R.id.tvWarmUpDescription);
//        DefensingWorkout defensingWorkout = new DefensingWorkout();
//        tvWarmUpDescription.setText(defensingWorkout.getWarmUpDescription());
//
//        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
//        tvWorkoutDescription.setText(defensingWorkout.getDescription());

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
                    AlertDialog.Builder builder = new AlertDialog.Builder(DefensingActivity.this);
                    builder.setTitle("End of Workout");
                    builder.setMessage("Are you sure you want to end this workout?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", new HandleAlertDialogListener());
                    builder.setNegativeButton("No", new HandleAlertDialogListener());
                    AlertDialog dialog = builder.create();
                    dialog.show();

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

    public class HandleAlertDialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if (which == -1) {
                startActivityForResult(new Intent(DefensingActivity.this, DefensingSurvyActivity.class), 0);
            }
        }

    }
}