package com.example.basketballtrain.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.basketballtrain.workouts.DribellingWorkout;

import java.util.ArrayList;

public class DribellingWorkoutHelper extends WorkoutDBHelper {

    public static final String TABLE_DRIBBLING_WORKOUTS ="tbl_dribbling_workouts";

    public static final String COLUMN_ID="id";
    public static final String COLUMN_SPIDER="spider";
    public static final String COLUMN_SLALOMW="slalom";
    public static final String COLUMN_TENNIS_BALL="tennis_ball";
    public static final String COLUMN_RUNNING="running";


    public static final String CREATE_TABLE_WORKOUTS="CREATE TABLE IF NOT EXISTS " +
            TABLE_DRIBBLING_WORKOUTS + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_SPIDER + " INTEGER, " +
            COLUMN_SLALOMW + " INTEGER, " +
            COLUMN_TENNIS_BALL + " INTEGER, " +
            COLUMN_RUNNING + " INTEGER " +  ")";


    String []allColumns={COLUMN_ID, COLUMN_SPIDER, COLUMN_TENNIS_BALL, COLUMN_SLALOMW, COLUMN_RUNNING};

    public DribellingWorkoutHelper(Context context) {
        super(context);
    }

    public void open()
    {
        database=this.getWritableDatabase();
        Log.i(this.getClass().getName(), "Database connection open");
    }

    public DribellingWorkout createDribellingWorkout(DribellingWorkout dribellingWorkout)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_SPIDER, dribellingWorkout.getSpider());
        values.put(COLUMN_SLALOMW, dribellingWorkout.getSlalom());
        values.put(COLUMN_TENNIS_BALL, dribellingWorkout.getTennisBall());
        values.put(COLUMN_RUNNING, dribellingWorkout.getRunning());

        long insertId=database.insert(TABLE_DRIBBLING_WORKOUTS, null, values);
        Log.i(this.getClass().getName(), "Dribbling Workout " + insertId + "insert to database");
        dribellingWorkout.setId(insertId);
        return dribellingWorkout;
    }

    public ArrayList<DribellingWorkout> getAllDribellingWorkouts() {

        ArrayList<DribellingWorkout> workouts = new ArrayList<DribellingWorkout>();
        String query = "select * from " + TABLE_DRIBBLING_WORKOUTS + " order by id desc";
        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                int spider = cursor.getInt(cursor.getColumnIndex(COLUMN_SPIDER));
                int slalom = cursor.getInt(cursor.getColumnIndex(COLUMN_SLALOMW));
                int tennisBall = cursor.getInt(cursor.getColumnIndex(COLUMN_TENNIS_BALL));
                int running = cursor.getInt(cursor.getColumnIndex(COLUMN_RUNNING));

                DribellingWorkout workout=new DribellingWorkout(spider, slalom, tennisBall, running);
                workout.setId(id);
                workouts.add(workout);
            }
        }
        return workouts;
    }
}
