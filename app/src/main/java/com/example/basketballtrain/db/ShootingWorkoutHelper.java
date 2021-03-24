package com.example.basketballtrain.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.basketballtrain.workouts.ShootingWorkout;

import java.util.ArrayList;

public class ShootingWorkoutHelper extends WorkoutDBHelper  {

    public static final String TABLE_SHOOTING_WORKOUTS ="tbl_shooting_workouts";

    public static final String COLUMN_ID="id";
    public static final String COLUMN_THREE_THROW="tree_throw";
    public static final String COLUMN_INSIDE_PAINT_THROW="inside_paint_throw";
    public static final String COLUMN_FREE_THROW="free_throw";
    public static final String COLUMN_DRIVE_THROW="drive_throw";


    public static final String CREATE_TABLE_WORKOUTS="CREATE TABLE IF NOT EXISTS " +
            TABLE_SHOOTING_WORKOUTS + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_THREE_THROW + " INTEGER, " +
            COLUMN_INSIDE_PAINT_THROW + " INTEGER, " +
            COLUMN_FREE_THROW + " INTEGER, " +
            COLUMN_DRIVE_THROW + " INTEGER " +  ")";


    String []allColumns={COLUMN_ID, COLUMN_THREE_THROW, COLUMN_FREE_THROW, COLUMN_INSIDE_PAINT_THROW, COLUMN_DRIVE_THROW};

    public ShootingWorkoutHelper(Context context) {
        super(context);
    }

    public ShootingWorkout createShootingWorkout(ShootingWorkout shootingWorkout)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_THREE_THROW, shootingWorkout.getThreeThrow());
        values.put(COLUMN_INSIDE_PAINT_THROW, shootingWorkout.getInsidePaintThrow());
        values.put(COLUMN_FREE_THROW, shootingWorkout.getFreeThrow());
        values.put(COLUMN_DRIVE_THROW, shootingWorkout.getDriveThrow());

        long insertId=database.insert(TABLE_SHOOTING_WORKOUTS, null, values);
        Log.i(this.getClass().getName(), "Shooting workout " + insertId + "insert to database");
        shootingWorkout.setId(insertId);
        return shootingWorkout;
    }

    public ArrayList<ShootingWorkout> getAllShootingWorkouts() {

        ArrayList<ShootingWorkout> workouts = new ArrayList<ShootingWorkout>();
        String query = "select * from " + TABLE_SHOOTING_WORKOUTS + " order by id desc";
        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                int threeThrow = cursor.getInt(cursor.getColumnIndex(COLUMN_THREE_THROW));
                int insidePaintThrow = cursor.getInt(cursor.getColumnIndex(COLUMN_INSIDE_PAINT_THROW));
                int freeThrow = cursor.getInt(cursor.getColumnIndex(COLUMN_FREE_THROW));
                int driveThrow = cursor.getInt(cursor.getColumnIndex(COLUMN_DRIVE_THROW));

                ShootingWorkout workout=new ShootingWorkout(threeThrow, insidePaintThrow, freeThrow, driveThrow);
                workout.setId(id);
                workouts.add(workout);
            }
        }
        return workouts;
    }

    public Double get3PointAvg() {
        String query = "select avg(" + COLUMN_THREE_THROW +  ") from " + TABLE_SHOOTING_WORKOUTS ;

        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            cursor.moveToNext();
            return cursor.getDouble(0);
        }

        return 0.0;
    }

    public Double get3PointBest() {
        String query = "select max(" + COLUMN_THREE_THROW +  ") from " + TABLE_SHOOTING_WORKOUTS ;

        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            cursor.moveToNext();
            return cursor.getDouble(0);
        }

        return 0.0;
    }
}
