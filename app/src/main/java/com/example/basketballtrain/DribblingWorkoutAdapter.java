package com.example.basketballtrain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.basketballtrain.workouts.DribellingWorkout;

import java.util.List;

public class DribblingWorkoutAdapter extends ArrayAdapter<DribellingWorkout> {

    Context context;
    List<DribellingWorkout> objects;
    public DribblingWorkoutAdapter(Context context, int resource, int textViewResourceId, List<DribellingWorkout> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dribelling_workout,parent,false);
        TextView tvShooting = (TextView)view.findViewById(R.id.tvShooting);
        DribellingWorkout workout = objects.get(position);
        String oneLine = "ID: " + workout.getId() + " spider: " + workout.getSpider() + " Slalom: " + workout.getSlalom() + " Running: " + workout.getRunning() + " Tennis ball: " + workout.getTennisBall();
        tvShooting.setText(String.valueOf(oneLine));
        return view;
    }
}