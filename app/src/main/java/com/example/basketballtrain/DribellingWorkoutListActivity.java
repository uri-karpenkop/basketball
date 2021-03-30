package com.example.basketballtrain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.DribellingWorkoutHelper;
import com.example.basketballtrain.workouts.DribellingWorkout;

import java.util.ArrayList;

public class DribellingWorkoutListActivity extends AppCompatActivity {

    ListView lv;
    Button btnBack;
    ArrayList<DribellingWorkout> dribellingWorkouts;
    DribblingWorkoutAdapter DribellingWorkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_dribelling_workout_activity);
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

        dribellingWorkouts = getAllDribellingWorkouts();

        DribellingWorkoutAdapter=new DribblingWorkoutAdapter(this,0,0,dribellingWorkouts);
        lv=(ListView)findViewById(R.id.lvDribelling);
        lv.setAdapter(DribellingWorkoutAdapter);

    }


    private ArrayList<DribellingWorkout> getAllDribellingWorkouts() {
        DribellingWorkoutHelper dbHelper = new DribellingWorkoutHelper(this);
        dbHelper.open();
        ArrayList<DribellingWorkout> dribellingWorkouts = dbHelper.getAllDribellingWorkouts();
        dbHelper.close();
        return dribellingWorkouts;
    }
}
