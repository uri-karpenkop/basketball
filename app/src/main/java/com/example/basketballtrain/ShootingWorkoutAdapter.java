package com.example.basketballtrain;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.basketballtrain.workouts.ShootingWorkout;

import java.util.List;

public class ShootingWorkoutAdapter extends ArrayAdapter<ShootingWorkout> {

    Context context;
    List<ShootingWorkout> objects;
    public ShootingWorkoutAdapter(Context context, int resource, int textViewResourceId, List<ShootingWorkout> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.shooting_workout,parent,false);
        TextView tvShooting = (TextView)view.findViewById(R.id.tvShooting);
        ShootingWorkout workout = objects.get(position);
        String oneLine = "ID: " + workout.getId() + " 3 Throw: " + workout.getThreeThrow();
        tvShooting.setText(String.valueOf(oneLine));
        return view;
    }
}