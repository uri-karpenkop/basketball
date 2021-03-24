package com.example.basketballtrain.workouts;

public abstract class BaseWorkout {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract String getDescription();

    public String getWarmUpDescription() {
        return "This is the warm up desc\n" +
                "Please do this and that";
    }

}
