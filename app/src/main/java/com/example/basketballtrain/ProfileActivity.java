package com.example.basketballtrain;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences sp;
    Button btnCreateProfile;
    EditText etUserName , etFirstName , etLastName , etEmail , etPhoneNumber , etAvailable , etNewPassword , etConfirmPassword ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        sp = getSharedPreferences("profile",0);
        etUserName = (EditText)findViewById(R.id.etUsername);
        etUserName.setText(sp.getString("userName", null));

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber );
        etAvailable = (EditText)findViewById(R.id.etAvailable);
        etNewPassword = (EditText)findViewById(R.id.etNewPassword);
        etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

        btnCreateProfile = (Button) findViewById(R.id.btnCreateProfile);
        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TEST", "------ clicked !!!! ----------" );
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("userName", etUserName.getText().toString());
                editor.putString("firstName", etFirstName.getText().toString());
                editor.putString("lastName", etLastName.getText().toString());
                editor.putString("email", etEmail.getText().toString());
                editor.putString("phoneNumber", etPhoneNumber.getText().toString());
                editor.putString("available", etAvailable.getText().toString());
                editor.putString("newPassword", etNewPassword.getText().toString());
                editor.putString("confirmPassword", etConfirmPassword.getText().toString());
                editor.commit();

//                if (getIntent().getStringExtra("from") == "MainActivity") {
//
//                }

                ProfileActivity.this.finish();

            }
        });






    }
}