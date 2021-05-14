package com.example.basketballtrain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.basketballtrain.workouts.DefensingWorkout;
import com.example.basketballtrain.workouts.PushupWorkout;

import java.util.List;

public class PushupsWorkoutAdapter extends ArrayAdapter<PushupWorkout> {

    Context context;
    List<PushupWorkout> objects;
    public PushupsWorkoutAdapter(Context context, int resource, int textViewResourceId, List<PushupWorkout> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.pushup_workout,parent,false);
        TextView tvDefensing = (TextView)view.findViewById(R.id.tvPushup);
        PushupWorkout workout = objects.get(position);
        String oneLine = "ID: " + workout.getId() + " number of pushups: " + workout.getNumOfPushups();
        tvDefensing.setText(String.valueOf(oneLine));
        return view;
    }
}