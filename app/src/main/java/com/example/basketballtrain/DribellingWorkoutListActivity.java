package com.example.basketballtrain;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.DribellingWorkoutHelper;
import com.example.basketballtrain.workouts.DribellingWorkout;

import java.util.ArrayList;

public class DribellingWorkoutListActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<DribellingWorkout> dribellingWorkouts;
    DribblingWorkoutAdapter DribellingWorkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_dribelling_workout_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
