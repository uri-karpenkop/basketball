package com.example.basketballtrain.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WorkoutDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "basketball.db";
    public static final int DATABASE_VERSION = 1;

    protected SQLiteDatabase database;

    public WorkoutDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShootingWorkoutHelper.CREATE_TABLE_WORKOUTS);
        db.execSQL(DefensingWorkoutHelper.CREATE_TABLE_WORKOUTS);
        db.execSQL(DribellingWorkoutHelper.CREATE_TABLE_WORKOUTS);
        Log.i(this.getClass().getName(), "All tables were created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void open()
    {
        database=this.getWritableDatabase();
        Log.i(this.getClass().getName(), "Database connection open");
    }
}
