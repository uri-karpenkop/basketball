package com.example.basketballtrain;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballtrain.db.DefensingWorkoutHelper;
import com.example.basketballtrain.db.DribellingWorkoutHelper;
import com.example.basketballtrain.db.ShootingWorkoutHelper;
import com.example.basketballtrain.db.WorkoutDBHelper;

public class HighestRecordsActivity extends AppCompatActivity {

    Button btnBack;
    TextView tv3PointAvg, tv3PointBest, tvPaintThrowAvg, tvPaintThrowBest, tvFreeThrowAvg, tvFreeThrowBest, tvDriveThrowAvg, tvDriveThrowBest;
    TextView  tvSpiderAvg, tvSpiderBest, tvSlalomAvg, tvSlalomBest, tvTennisBallAvg, tvTennisBallBest, tvRunningAvg, tvRunningBest;
    TextView tvTenTimesFourAvg, tvTenTimesFourBest, tvSlantAvg, tvSlantBest, tvSquatAvg, tvSquatBest, tvLanceAvg, tvLanceBest;
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
        Double freeThrowAvg = getAvg(ShootingWorkoutHelper.COLUMN_FREE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvFreeThrowAvg.setText(String.format("%.2f", freeThrowAvg));

        tvFreeThrowBest = (TextView)findViewById(R.id.tvFreeThrowBest);
        Double freeThrowBest = getBest(ShootingWorkoutHelper.COLUMN_FREE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvFreeThrowBest.setText(String.format("%.2f", freeThrowBest));

        tvDriveThrowAvg = (TextView)findViewById(R.id.tvDriveThrowAvg);
        Double driveThrowAvg = getAvg(ShootingWorkoutHelper.COLUMN_DRIVE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvDriveThrowAvg.setText(String.format("%.2f", driveThrowAvg));

        tvDriveThrowBest = (TextView)findViewById(R.id.tvDriveThrowBest);
        Double driveThrowBest = getBest(ShootingWorkoutHelper.COLUMN_DRIVE_THROW, ShootingWorkoutHelper.TABLE_SHOOTING_WORKOUTS);
        tvDriveThrowBest.setText(String.format("%.2f", driveThrowBest));


        tvSpiderAvg = (TextView)findViewById(R.id.tvSpiderAvg);
        Double spiderAvg = getAvg(DribellingWorkoutHelper.COLUMN_SPIDER, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvSpiderAvg.setText(String.format("%.2f", spiderAvg));

        tvSpiderBest = (TextView)findViewById(R.id.tvSpiderBest);
        Double spiderBest = getBest(DribellingWorkoutHelper.COLUMN_SPIDER, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvSpiderBest.setText(String.format("%.2f", spiderBest));

        tvSlalomAvg = (TextView)findViewById(R.id.tvSlalomAvg);
        Double slalomAvg = getAvg(DribellingWorkoutHelper.COLUMN_SLALOMW, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvSlalomAvg.setText(String.format("%.2f", slalomAvg));

        tvSlalomBest = (TextView)findViewById(R.id.tvSlalomBest);
        Double slalomBest = getBest(DribellingWorkoutHelper.COLUMN_SLALOMW, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvSlalomBest.setText(String.format("%.2f", slalomBest));

        tvTennisBallAvg = (TextView)findViewById(R.id.tvTennisBallAvg);
        Double tennisBallAvg = getAvg(DribellingWorkoutHelper.COLUMN_TENNIS_BALL, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvTennisBallAvg.setText(String.format("%.2f", tennisBallAvg));

        tvTennisBallBest = (TextView)findViewById(R.id.tvTennisBallBest);
        Double tennisBallBest = getBest(DribellingWorkoutHelper.COLUMN_TENNIS_BALL, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvTennisBallBest.setText(String.format("%.2f", tennisBallBest));

        tvRunningAvg = (TextView)findViewById(R.id.tvRunningAvg);
        Double runningAvg = getAvg(DribellingWorkoutHelper.COLUMN_RUNNING, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvRunningAvg.setText(String.format("%.2f", runningAvg));

        tvRunningBest = (TextView)findViewById(R.id.tvRunningBest);
        Double runningBest = getBest(DribellingWorkoutHelper.COLUMN_RUNNING, DribellingWorkoutHelper.TABLE_DRIBBLING_WORKOUTS);
        tvRunningBest.setText(String.format("%.2f", runningBest));

        tvTenTimesFourAvg = (TextView)findViewById(R.id.tvTenTimesFourAvg);
        Double tenTimesFourAvg = getAvg(DefensingWorkoutHelper.COLUMN_TEN_TIMES_FOUR, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvTenTimesFourAvg.setText(String.format("%.2f", tenTimesFourAvg));

        tvTenTimesFourBest = (TextView)findViewById(R.id.tvTenTimesFourBest);
        Double tenTimesFourBest = getBest(DefensingWorkoutHelper.COLUMN_TEN_TIMES_FOUR, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvTenTimesFourBest.setText(String.format("%.2f", tenTimesFourBest));

        tvSlantAvg = (TextView)findViewById(R.id.tvSlantAvg);
        Double slantAvg = getAvg(DefensingWorkoutHelper.COLUMN_SLANT, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvSlantAvg.setText(String.format("%.2f", slantAvg));

        tvSlantBest = (TextView)findViewById(R.id.tvSlantBest);
        Double slantBest = getBest(DefensingWorkoutHelper.COLUMN_SLANT, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvSlantBest.setText(String.format("%.2f", slantBest));

        tvSquatAvg = (TextView)findViewById(R.id.tvSquatAvg);
        Double squatAvg = getAvg(DefensingWorkoutHelper.COLUMN_SQUAT, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvSquatAvg.setText(String.format("%.2f", squatAvg));

        tvSquatBest = (TextView)findViewById(R.id.tvSquatBest);
        Double squatBest = getBest(DefensingWorkoutHelper.COLUMN_SQUAT, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvSquatBest.setText(String.format("%.2f", squatBest));

        tvLanceAvg = (TextView)findViewById(R.id.tvLanceAvg);
        Double lanceAvg = getAvg(DefensingWorkoutHelper.COLUMN_LANCE, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvLanceAvg.setText(String.format("%.2f", lanceAvg));

        tvLanceBest = (TextView)findViewById(R.id.tvLanceBest);
        Double lanceBest = getBest(DefensingWorkoutHelper.COLUMN_LANCE, DefensingWorkoutHelper.TABLE_DEFENSING_WORKOUTS);
        tvLanceBest.setText(String.format("%.2f", lanceBest));




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