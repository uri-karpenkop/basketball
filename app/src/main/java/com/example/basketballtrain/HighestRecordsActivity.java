package com.example.basketballtrain;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.db.WorkoutDBHelper;

public class HighestRecordsActivity extends AppCompatActivity {

    Button btnBack;
    TextView tv3PointAvg, tv3PointBest, tvPaintThrowAvg, tvPaintThrowBest, tvFreeThrowAvg, tvFreeThrowBest, tvDriveThrowAvg, tvDriveThrowBest;
    WorkoutDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_records);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v == btnBack) {
                    finish();
                }
            }
        });
        dbHelper = new WorkoutDBHelper(this);

        tv3PointAvg = (TextView)findViewById(R.id.tv3PointAvg);
        Double threePointAvg = getAvg(ShootingWorkoutHelper.COLUMN_THREE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tv3PointAvg.setText(String.format("%.2f", threePointAvg));

        tv3PointBest = (TextView)findViewById(R.id.tv3PointBest);
        Double threePointBest = getBest(ShootingWorkoutHelper.COLUMN_THREE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tv3PointBest.setText(String.format("%.2f", threePointBest));

        tvPaintThrowAvg = (TextView)findViewById(R.id.tvInsideThePaintAvg);
        Double paintThrowAvg = getAvg(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvPaintThrowAvg.setText(String.format("%.2f", paintThrowAvg));

        tvPaintThrowBest = (TextView)findViewById(R.id.tvInsideThePaintBest);
        Double paintThrowBest = getBest(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvPaintThrowBest.setText(String.format("%.2f", paintThrowBest));

        tvFreeThrowAvg = (TextView)findViewById(R.id.tvFreeThrowAvg);
        Double freeThrowAvg = getAvg(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvPaintThrowAvg.setText(String.format("%.2f", freeThrowAvg));

        tvFreeThrowBest = (TextView)findViewById(R.id.tvFreeThrowBest);
        Double freeThrowBest = getBest(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvPaintThrowBest.setText(String.format("%.2f", freeThrowBest));

        tvDriveThrowAvg = (TextView)findViewById(R.id.tvDriveThrowAvg);
        Double driveThrowAvg = getAvg(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvDriveThrowAvg.setText(String.format("%.2f", driveThrowAvg));

        tvDriveThrowBest = (TextView)findViewById(R.id.tvDriveThrowBest);
        Double driveThrowBest = getBest(ShootingWorkoutHelper.COLUMN_INSIDE_PAINT_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvDriveThrowBest.setText(String.format("%.2f", driveThrowBest));



    }

    private Double getAvg(String columnName, String tableName) {
        dbHelper.open();
        Double avg = dbHelper.getAvg(columnName, tableName);
        dbHelper.close();
        return avg;
    }

    private Double getBest(String columnName, String tableName) {
        dbHelper.open();
        Double max = dbHelper.getBest(columnName, tableName);
        dbHelper.close();
        return max;
    }

}