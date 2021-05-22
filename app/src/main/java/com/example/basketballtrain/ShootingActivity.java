package com.example.basketballtrain;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.workouts.ShootingWorkout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShootingActivity extends AppCompatActivity {

    Button btnBack , btnDone;
    TextView tvWarmUpDescription, tvWorkoutDescription;
    ShootingWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new ShootingWorkoutHelper(this);
        setContentView(R.layout.activity_shooting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvWarmUpDescription = findViewById(R.id.tvWarmUpDescription);
        ShootingWorkout shootingWorkout = new ShootingWorkout();
        tvWarmUpDescription.setText(shootingWorkout.getWarmUpDescription());

        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
        tvWorkoutDescription.setText(shootingWorkout.getDescription());

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

                    AlertDialog.Builder builder = new AlertDialog.Builder(ShootingActivity.this);
                    builder.setTitle("End of Workout");
                    builder.setMessage("Are you sure you want to end this workout?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Yes", new HandleAlertDialogListener());
                    builder.setNegativeButton("No", new HandleAlertDialogListener());
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Integer numberOfThreeShoots = data.getIntExtra("numberOfThreeShoots", 0);
        Log.d(this.getClass().getName(), "The number of three Shoots is " + numberOfThreeShoots);

        Integer numberOfPaintShoots = data.getIntExtra("numberOfPaintShoots", 0);
        Log.d(this.getClass().getName(), "The number of paint shoots is " + numberOfPaintShoots);

        Integer numberOfFreeThrow = data.getIntExtra("numberOfFreeThrow", 0);
        Log.d(this.getClass().getName(), "The number of free shoots is " + numberOfFreeThrow);

        Integer numberOfExtensionsShoots = data.getIntExtra("numberOfExtensionsShoots", 0);
        Log.d(this.getClass().getName(), "The number of extension shoots is " + numberOfExtensionsShoots);

        // save to database

        ShootingWorkout shootingWorkout = new ShootingWorkout(numberOfThreeShoots, numberOfPaintShoots, numberOfFreeThrow, numberOfExtensionsShoots);
        dbHelper.open();
        dbHelper.createShootingWorkout(shootingWorkout);
        dbHelper.close();


        Log.i(this.getClass().getName(), "The id for the workout is: " + shootingWorkout.getId());

        finish();
    }

    public  class  HandleAlertDialogListener implements DialogInterface.OnClickListener
    {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if (which == -1) {
                startActivityForResult(new Intent(ShootingActivity.this, ShootingSurvyActivity.class), 0);
            }
        }
    }

}