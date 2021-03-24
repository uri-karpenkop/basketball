package com.example.basketballtrain;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DribellingSurvyActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etSpider , etSlalom , etTennisBall , etRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dribelling_survy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etSpider = (EditText) findViewById(R.id.etSpider);
        etSlalom = (EditText) findViewById(R.id.etSlalom);
        etTennisBall = (EditText) findViewById(R.id.etTennisBall);
        etRunning = (EditText) findViewById(R.id.etRunning);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnSubmit){
                    Integer spider =  Integer.parseInt(etSpider.getText().toString());
                    Intent result = new Intent();
                    result.putExtra("numberOfTimesBallEscapedSpider", spider);

                    Integer slalom =  Integer.parseInt(etSlalom.getText().toString());
                    result.putExtra("numberOfTimesBallEscapedSlalom", slalom);

                    Integer tennisBall =  Integer.parseInt(etTennisBall.getText().toString());
                    result.putExtra("numberOfTimesBallEscapedTennisBall", tennisBall);

                    Integer running =  Integer.parseInt(etRunning.getText().toString());
                    result.putExtra("numberOfTimesBallEscapedRunning", running);

                    setResult(Activity.RESULT_OK, result);

                    finish();
                }
            }

        });


    }
}