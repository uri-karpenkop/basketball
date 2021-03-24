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

public class DefensingSurvyActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etTenTimesFour , etSlant , etSquat , etLance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defensing_survy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etTenTimesFour = (EditText) findViewById(R.id.etTenTimesFour);
        etSlant = (EditText) findViewById(R.id.etSlant);
        etSquat = (EditText) findViewById(R.id.etSquat);
        etLance = (EditText) findViewById(R.id.etLance);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnSubmit){
                    Integer numberOfTenTimesFour =  Integer.parseInt(etTenTimesFour.getText().toString());
                    Intent result = new Intent();
                    result.putExtra("numberOfTenTimesFour", numberOfTenTimesFour);

                    Integer numberOfSlant =  Integer.parseInt(etSlant.getText().toString());
                    result.putExtra("numberOfSlant", numberOfSlant);

                    Integer numberOfSquat =  Integer.parseInt(etSquat.getText().toString());
                    result.putExtra("numberOfSquat", numberOfSquat);

                    Integer numberOfLance =  Integer.parseInt(etLance.getText().toString());
                    result.putExtra("numberOfLance", numberOfLance);

                    setResult(Activity.RESULT_OK, result);

                    finish();
                }
            }

        });


    }
}