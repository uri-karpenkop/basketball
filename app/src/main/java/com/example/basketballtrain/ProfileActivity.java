package com.example.basketballtrain;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.basketballtrain.user.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences sp;
    Button btnCreateProfile, btnTakePic;
    EditText etUserName , etFirstName , etLastName , etEmail , etPhoneNumber ;
    Bitmap bitmap;
    ImageView ivProfile;
    String pathToPic;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        sp = getSharedPreferences("profile",0);
        etUserName = (EditText)findViewById(R.id.etUsername);
        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);

        // get all fields from sp (if exists)
        String userName = sp.getString("userName", "");
        String firstName = sp.getString("firstName", "");
        String lastName = sp.getString("lastName", "");
        String email = sp.getString("email", "");
        String phoneNumber = sp.getString("phoneNumber", "");
        pathToPic = sp.getString("photo", null);

        // create new profile object from fields
        Profile userProfile = new Profile(userName, firstName, lastName, email, phoneNumber, pathToPic);


        // show the data on the screen
        etUserName.setText(userProfile.getUserName());
        etFirstName.setText(userProfile.getFirstName());
        etLastName.setText(userProfile.getLastName());
        etEmail.setText(userProfile.getEmail());
        etPhoneNumber.setText(userProfile.getPhoneNumber());

        // if has picture load it
        if (userProfile.getPathToPicture() != null) {
            loadImageFromStorage(userProfile.getPathToPicture());
        }

        // find the TAKE PIC button
        btnTakePic = (Button)findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            // TAKE PICTURE button
            @Override
            public void onClick(View v)
            {
                if(v==btnTakePic)
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,0);
                }
            }
        });

        // save
        btnCreateProfile = (Button) findViewById(R.id.btnCreateProfile);
        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get all data from screen and save to shared preferences
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("userName", etUserName.getText().toString());
                editor.putString("firstName", etFirstName.getText().toString());
                editor.putString("lastName", etLastName.getText().toString());
                editor.putString("email", etEmail.getText().toString());
                editor.putString("phoneNumber", etPhoneNumber.getText().toString());
                if (pathToPic != null) {
                    editor.putString("photo", pathToPic);
                }
                //save
                editor.commit();

//                if (getIntent().getStringExtra("from") == "MainActivity") {
//
//                }

                ProfileActivity.this.finish();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // result return from taking picture
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)//coming from camera
        {
            if(resultCode==RESULT_OK)
            {
                // get bitmap from intent
                bitmap= (Bitmap)data.getExtras().get("data");

                // save bitmap to ImageView
                ivProfile.setImageBitmap(bitmap);

                // save bitmap to file
                pathToPic = saveToInternalStorage(bitmap);
            }
        }
    }

    // save bitmap to file
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    // load bitmap from file
    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ivProfile.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}