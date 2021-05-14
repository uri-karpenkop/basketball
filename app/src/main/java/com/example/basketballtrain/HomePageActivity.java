package com.example.basketballtrain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {
    Button  btnShooting, btnDefensing, btnDriblling, btnPushups;
    BroadCastBattery broadCastBattery;
    int batteryToastCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        broadCastBattery = new BroadCastBattery();

        btnShooting = (Button) findViewById(R.id.btnShooting);
        btnShooting.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnShooting){
                    startActivity(new Intent(HomePageActivity.this, ShootingActivity.class));
                }
            }

        });

        btnDefensing = (Button) findViewById(R.id.btnDefensing);
        btnDefensing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnDefensing){
                    startActivity(new Intent(HomePageActivity.this, DefensingActivity.class));

                }
            }

        });
        btnDriblling = (Button) findViewById(R.id.btnDriblling);
        btnDriblling.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnDriblling){
                    startActivity(new Intent(HomePageActivity.this, DribellingActivity.class));

                }
            }

        });
        btnPushups = (Button) findViewById(R.id.btnPushups);
        btnPushups.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(v == btnPushups){
                    startActivity(new Intent(HomePageActivity.this, PushupsActivity.class));
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_profile) {
            Intent intent = new Intent(HomePageActivity.this, ProfileActivity.class);
            intent.putExtra("from", "HomePageActivity");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_statistics) {
            startActivity(new Intent(HomePageActivity.this, StatisticActivity.class));
            return true;
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        batteryToastCounter = 0;
        Log.d(this.getClass().getName(), "----- Listen to battery changes (on resume)");
        registerReceiver(broadCastBattery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }



//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(broadCastBattery);
//    }


    private class BroadCastBattery extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            int batteryLevel = intent.getIntExtra("level",0);
            Log.d(this.getClass().getName(), "----- The battery level is : " + batteryLevel);

            if (batteryLevel <= 30 && batteryToastCounter < 2) {
                batteryToastCounter++;
                CharSequence text = "Battery is low, Please consider charging your device before starting a new Workout!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        }
    }
}


