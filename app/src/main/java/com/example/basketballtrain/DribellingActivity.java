package com.example.basketballtrain;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.basketballtrain.db.DribellingWorkoutHelper;
import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.workouts.DribellingWorkout;
import com.example.basketballtrain.workouts.ShootingWorkout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
public class DribellingActivity extends AppCompatActivity {

    Button btnBack , btnDone;
    DribellingWorkoutHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DribellingWorkoutHelper(this);
        setContentView(R.layout.activity_dribeling);
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
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnDone) {
                    startActivityForResult(new Intent(DribellingActivity.this, DribellingSurvyActivity.class), 0);

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

}