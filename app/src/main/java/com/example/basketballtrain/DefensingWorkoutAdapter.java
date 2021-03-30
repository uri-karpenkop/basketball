package com.example.basketballtrain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.basketballtrain.workouts.DefensingWorkout;

import java.util.List;

public class DefensingWorkoutAdapter extends ArrayAdapter<DefensingWorkout> {

    Context context;
    List<DefensingWorkout> objects;
    public DefensingWorkoutAdapter(Context context, int resource, int textViewResourceId, List<DefensingWorkout> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.defensing_workout,parent,false);
        TextView tvDefensing = (TextView)view.findViewById(R.id.tvDefensing);
        DefensingWorkout workout = objects.get(position);
        String oneLine = "ID: " + workout.getId() + " ten times four: " + workout.getTenTInesFour() + " Slant " + workout.getSlant() +" Squat: " + workout.getSquat() + " lance: " + workout.getLance();
        tvDefensing.setText(String.valueOf(oneLine));
        return view;
    }
}