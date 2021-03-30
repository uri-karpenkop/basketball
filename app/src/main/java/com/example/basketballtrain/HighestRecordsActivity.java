package com.example.basketballtrain;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basketballtrain.db.ShootingWorkoutHelper;

public class HighestRecordsActivity extends AppCompatActivity {

    Button btnBack;
    TextView tv3PointAvg, tv3PointBest, tvPaintThrowAvg, tvPaintThrowBest;
    ShootingWorkoutHelper dbHelper;

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
        dbHelper = new ShootingWorkoutHelper(this);

        tv3PointAvg = (TextView)findViewById(R.id.tv3PointAvg);
        tv3PointAvg.setText(get3PointAvg().toString());

        tv3PointBest = (TextView)findViewById(R.id.tv3PointBest);
        tv3PointBest.setText(get3PointBest().toString());

    }

    private Double get3PointAvg() {
        dbHelper.open();
        Double avg = dbHelper.get3PointAvg();
        dbHelper.close();
        return avg;
    }

    private Double get3PointBest() {
        dbHelper.open();
        Double max = dbHelper.get3PointBest();
        dbHelper.close();
        return max;
    }

}