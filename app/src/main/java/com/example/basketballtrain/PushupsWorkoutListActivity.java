package com.example.basketballtrain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.db.PushupsWorkoutHelper;
import com.example.basketballtrain.workouts.DefensingWorkout;
import com.example.basketballtrain.workouts.PushupWorkout;

import java.util.ArrayList;

public class PushupsWorkoutListActivity extends AppCompatActivity {

    ListView lv;
    Button btnBack;
    ArrayList<PushupWorkout> pushupWorkouts;
    PushupsWorkoutAdapter pushupsWorkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_pushups_workouts_activity);
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

        pushupWorkouts = getAllPushupsWorkouts();

        pushupsWorkoutAdapter =new PushupsWorkoutAdapter(this,0,0, pushupWorkouts);
        lv=(ListView)findViewById(R.id.lvPushups);
        lv.setAdapter(pushupsWorkoutAdapter);

    }


    private ArrayList<PushupWorkout> getAllPushupsWorkouts() {
        PushupsWorkoutHelper dbHelper = new PushupsWorkoutHelper(this);
        dbHelper.open();
        ArrayList<PushupWorkout> allPushupsWorkouts = dbHelper.getAllPushupsWorkouts();
        dbHelper.close();
        return allPushupsWorkouts;
    }
}
