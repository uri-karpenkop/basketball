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
import android.widget.Toast;

public class ShootingSurvyActivity extends AppCompatActivity {

Button btnSubmit;
EditText etNumOfThreeShoot , etNumOfShootsPaint , etNumOfShootsFreeThrow , etNumOfShootsExtensions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        etNumOfThreeShoot = (EditText) findViewById(R.id.etNumOfThreeShoot);
        etNumOfShootsPaint = (EditText) findViewById(R.id.etNumOfShootsPaint);
        etNumOfShootsFreeThrow = (EditText) findViewById(R.id.etNumOfShootsFreeThrow);
        etNumOfShootsExtensions = (EditText) findViewById(R.id.etNumOfShootsExtensions);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

         public void onClick(View v) {
       if(v == btnSubmit){
           Intent result = new Intent();

           try {
               Integer numberOfThreeShoots = Integer.parseInt(etNumOfThreeShoot.getText().toString());
               result.putExtra("numberOfThreeShoots", numberOfThreeShoots);

               Integer numberOfPaintShoots = Integer.parseInt(etNumOfShootsPaint.getText().toString());
               result.putExtra("numberOfPaintShoots", numberOfPaintShoots);

               Integer numberOfFreeThrow = Integer.parseInt(etNumOfShootsFreeThrow.getText().toString());
               result.putExtra("numberOfFreeThrow", numberOfFreeThrow);

               Integer numberOfExtensionsShoots = Integer.parseInt(etNumOfShootsExtensions.getText().toString());
               result.putExtra("numberOfExtensionsShoots", numberOfExtensionsShoots);

               setResult(Activity.RESULT_OK, result);
               finish();

           } catch(Exception e) {
               Toast toast = Toast.makeText(getApplicationContext(), "All fields are mandatory.", Toast.LENGTH_LONG);
               toast.show();
           }

       }
           }

        });


    }
}