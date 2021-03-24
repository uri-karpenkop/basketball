package com.example.basketballtrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("profile",0);
        if(sp.getString("userName",null) == null){
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        } else{
            startActivity(new Intent(MainActivity.this, HomePageActivity.class));

        }
    }

}