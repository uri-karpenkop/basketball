package com.example.basketballtrain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
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
    TextView tvWorkoutDescription, tvTimer;
    PushupsWorkoutHelper dbHelper;
    Intent intent;
    boolean backBtnClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new PushupsWorkoutHelper(this);
        setContentView(R.layout.activity_pushups);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final PushupWorkout pushupWorkout = new PushupWorkout();

        tvWorkoutDescription = findViewById(R.id.tvWorkoutDescription);
        tvTimer = findViewById(R.id.tvTimer);
        tvWorkoutDescription.setText(pushupWorkout.getDescription());

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnBack) {
                    backBtnClicked = true;
                    if (intent != null) {
                        stopService(intent);
                    }
                    finish();
                }
            }

        });

        // button START Timer
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnStart) {
                    backBtnClicked = false;

                   // start timer with handler and messenger
                    // https://stackoverflow.com/questions/7871521/how-to-collect-info-from-intentservice-and-update-android-ui

                    intent  = new Intent(PushupsActivity.this, TimerIntentService.class);
                    intent.putExtra("counter", PushupWorkout.PRIOD_OF_TIME_IN_MINUTES * 60);
                    intent.putExtra("messenger", new Messenger(handler));
                    startService(intent);

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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle reply = msg.getData();
            int seconds = reply.getInt("timer");
            String secondsPaddedWithZeros = String.format("%02d", seconds);
            tvTimer.setText("00:" + secondsPaddedWithZeros);
            if (seconds == 0 && backBtnClicked == false ) {
                startActivityForResult(new Intent(PushupsActivity.this, PushupsSurvyActivity.class), 0);
            }
        }
    };
}