package com.example.basketballtrain.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.basketballtrain.workouts.DefensingWorkout;

import java.util.ArrayList;

public class DefensingWorkoutHelper extends WorkoutDBHelper {

    public static final String TABLE_DEFENSING_WORKOUTS ="tbl_defensing_workouts";

    public static final String COLUMN_ID="id";
    public static final String COLUMN_TEN_TIMES_FOUR="ten_times_four";
    public static final String COLUMN_SLANT="slant";
    public static final String COLUMN_SQUAT="squat";
    public static final String COLUMN_LANCE="lance";


    public static final String CREATE_TABLE_WORKOUTS="CREATE TABLE IF NOT EXISTS " +
            TABLE_DEFENSING_WORKOUTS + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TEN_TIMES_FOUR + " INTEGER, " +
            COLUMN_SLANT + " INTEGER, " +
            COLUMN_SQUAT + " INTEGER, " +
            COLUMN_LANCE + " INTEGER " +  ")";


    String []allColumns={COLUMN_ID, COLUMN_TEN_TIMES_FOUR, COLUMN_SQUAT, COLUMN_SLANT, COLUMN_LANCE};

    public DefensingWorkoutHelper(Context context) {
        super(context);
    }

    public DefensingWorkout createDefensingWorkout(DefensingWorkout defensingWorkout)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_TEN_TIMES_FOUR, defensingWorkout.getTenTInesFour());
        values.put(COLUMN_SLANT, defensingWorkout.getSlant());
        values.put(COLUMN_SQUAT, defensingWorkout.getSquat());
        values.put(COLUMN_LANCE, defensingWorkout.getLance());

        long insertId=database.insert(TABLE_DEFENSING_WORKOUTS, null, values);
        Log.i(this.getClass().getName(), "Defensing Workout " + insertId + "insert to database");
        defensingWorkout.setId(insertId);
        return defensingWorkout;
    }

    public ArrayList<DefensingWorkout> getAllDefensingWorkouts() {

        ArrayList<DefensingWorkout> workouts = new ArrayList<DefensingWorkout>();
        String query = "select * from " + TABLE_DEFENSING_WORKOUTS + " order by id desc";
        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                int tenTinesFour = cursor.getInt(cursor.getColumnIndex(COLUMN_TEN_TIMES_FOUR));
                int slant = cursor.getInt(cursor.getColumnIndex(COLUMN_SLANT));
                int squat = cursor.getInt(cursor.getColumnIndex(COLUMN_SQUAT));
                int lance = cursor.getInt(cursor.getColumnIndex(COLUMN_LANCE));

                DefensingWorkout workout=new DefensingWorkout(tenTinesFour, slant, squat, lance);
                workout.setId(id);
                workouts.add(workout);
            }
        }
        return workouts;
    }
}
