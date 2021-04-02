package com.example.basketballtrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, HomePageActivity.class));

        sp = getSharedPreferences("profile",0);
        String userNameFromSharedProps = sp.getString("userName",null);
        if(userNameFromSharedProps == null || userNameFromSharedProps == ""){
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("from", "MainActivity");
            startActivity(intent);
        }
    }
}