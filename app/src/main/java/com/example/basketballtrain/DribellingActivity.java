package com.example.basketballtrain;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.basketballtrain.db.DribellingWorkoutHelper;
import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.workouts.DribellingWorkout;
import com.example.basketballtrain.workouts.ShootingWorkout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DribellingActivity extends AppCompatActivity {

    Button btnBack , btnDone;
    TextView tvWarmUpDescription, tvWorkoutDescription;
    DribellingWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DribellingWorkoutHelper(this);
        setContentView(R.layout.activity_dribeling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvWarmUpDescription = findViewById(R.id.tvWarmUpDescription);
        DribellingWorkout dribellingWorkout = new DribellingWorkout();
        tvWarmUpDescription.setText(dribellingWorkout.getWarmUpDescription());

        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
        tvWorkoutDescription.setText(dribellingWorkout.getDescription());

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
                    AlertDialog.Builder builder = new AlertDialog.Builder(DribellingActivity.this);
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
        Integer spider = data.getIntExtra("numberOfTimesBallEscapedSpider", 0);
        Log.d(this.getClass().getName(), "number of ball escape spider" + spider);

        Integer slalom = data.getIntExtra("numberOfTimesBallEscapedSlalom", 0);
        Log.d(this.getClass().getName(), "number of ball escape slalom" + slalom);

        Integer tennisBall = data.getIntExtra("numberOfTimesBallEscapedTennisBall", 0);
        Log.d(this.getClass().getName(), "number of ball escape using tennis bal " + tennisBall);

        Integer running = data.getIntExtra("numberOfTimesBallEscapedRunning", 0);
        Log.d(this.getClass().getName(), "number of ball escape while running " + running);

        // save to database

        DribellingWorkout dribellingWorkout = new DribellingWorkout(spider, slalom, tennisBall, running);
        dbHelper.open();
        dbHelper.createDribellingWorkout(dribellingWorkout);
        dbHelper.close();

        Log.i(this.getClass().getName(), "The id for the workout is: " + dribellingWorkout.getId());
        finish();
    }
        public  class  HandleAlertDialogListener implements DialogInterface.OnClickListener
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which == -1) {
                    startActivityForResult(new Intent(DribellingActivity.this, DribellingSurvyActivity.class), 0);
                }
            }
        }
    }