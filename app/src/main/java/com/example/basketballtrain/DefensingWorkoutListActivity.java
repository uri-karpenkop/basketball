package com.example.basketballtrain;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.workouts.DefensingWorkout;

import java.util.ArrayList;

public class DefensingWorkoutListActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<DefensingWorkout> defensingWorkouts;
    DefensingWorkoutAdapter defensingWorkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_defensing_workouts_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        defensingWorkouts = getAllDefensingWorkouts();

        defensingWorkoutAdapter=new DefensingWorkoutAdapter(this,0,0,defensingWorkouts);
        lv=(ListView)findViewById(R.id.lvDefensing);
        lv.setAdapter(defensingWorkoutAdapter);

    }


    private ArrayList<DefensingWorkout> getAllDefensingWorkouts() {
        DefensingWorkoutHelper dbHelper = new DefensingWorkoutHelper(this);
        dbHelper.open();
        ArrayList<DefensingWorkout> defensingWorkouts = dbHelper.getAllDefensingWorkouts();
        dbHelper.close();
        return defensingWorkouts;
    }
}
