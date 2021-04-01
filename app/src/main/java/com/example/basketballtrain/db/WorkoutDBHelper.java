package com.example.basketballtrain.db;

import android.content.Context;
import android.database.Cursor;
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

    public Double getAvg(String columnName, String tableName) {
        String query = "select avg(" + columnName +  ") from " + tableName ;

        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            cursor.moveToNext();
            return cursor.getDouble(0);
        }

        return 0.0;
    }

    public Double getBest(String columnName, String tableName) {
        String query = "select max(" + columnName +  ") from " + tableName ;

        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            cursor.moveToNext();
            return cursor.getDouble(0);
        }

        return 0.0;
    }
}
