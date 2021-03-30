package com.example.basketballtrain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.workouts.ShootingWorkout;

import java.util.ArrayList;

public class ShootingWorkoutListActivity extends AppCompatActivity {

    ListView lv;
    Button btnBack;
    ArrayList<ShootingWorkout> shootingWorkouts;
    ShootingWorkoutAdapter shootingWorkoutAdapter;
    ShootingWorkoutHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new ShootingWorkoutHelper(this);
        setContentView(R.layout.all_shooting_workouts_activity);
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

        shootingWorkouts = getAllShootingWorkouts();

        shootingWorkoutAdapter=new ShootingWorkoutAdapter(this,0,0,shootingWorkouts);
        lv=(ListView)findViewById(R.id.lvShooting);
        lv.setAdapter(shootingWorkoutAdapter);

    }


    private ArrayList<ShootingWorkout> getAllShootingWorkouts() {
        dbHelper.open();
        ArrayList<ShootingWorkout> shootingWorkouts = dbHelper.getAllShootingWorkouts();
        dbHelper.close();
        return shootingWorkouts;
    }
}
