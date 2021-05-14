package com.example.basketballtrain.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.basketballtrain.workouts.DefensingWorkout;
import com.example.basketballtrain.workouts.PushupWorkout;

import java.util.ArrayList;

public class PushupsWorkoutHelper extends WorkoutDBHelper {

    public static final String TABLE_PUSHUPS_WORKOUTS ="tbl_pushups_workouts";

    public static final String COLUMN_ID="id";
    public static final String COLUMN_NUM_OF_PUSHUPS ="num_of_pushups";

    public static final String CREATE_TABLE_WORKOUTS="CREATE TABLE IF NOT EXISTS " +
            TABLE_PUSHUPS_WORKOUTS + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NUM_OF_PUSHUPS + " INTEGER  )";


    String []allColumns={COLUMN_ID, COLUMN_NUM_OF_PUSHUPS};

    public PushupsWorkoutHelper(Context context) {
        super(context);
    }

    public PushupWorkout createPushupsWorkout(PushupWorkout pushupsWorkout)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_NUM_OF_PUSHUPS, pushupsWorkout.getNumOfPushups());

        long insertId=database.insert(TABLE_PUSHUPS_WORKOUTS, null, values);
        Log.i(this.getClass().getName(), "Pushups Workout " + insertId + "insert to database");
        pushupsWorkout.setId(insertId);
        return pushupsWorkout;
    }

    public ArrayList<PushupWorkout> getAllPushupsWorkouts() {

        ArrayList<PushupWorkout> workouts = new ArrayList<PushupWorkout>();
        String query = "select * from " + TABLE_PUSHUPS_WORKOUTS + " order by id desc";
        Cursor cursor=database.rawQuery(query,null);

        if(cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                int numOfPushups = cursor.getInt(cursor.getColumnIndex(COLUMN_NUM_OF_PUSHUPS));

                PushupWorkout workout=new PushupWorkout(numOfPushups);
                workout.setId(id);
                workouts.add(workout);
            }
        }
        return workouts;
    }
}
