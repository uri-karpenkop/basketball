package com.example.basketballtrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PushupsSurvyActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etNumOfPushups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushups_survy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etNumOfPushups = (EditText) findViewById(R.id.etNumOfPushups);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnSubmit){
                    Integer numOfPushups =  Integer.parseInt(etNumOfPushups.getText().toString());
                    Intent result = new Intent();
                    result.putExtra("numOfPushups", numOfPushups);

                    setResult(Activity.RESULT_OK, result);

                    finish();
                }
            }

        });


    }
}