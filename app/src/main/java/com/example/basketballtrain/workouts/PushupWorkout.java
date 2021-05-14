package com.example.basketballtrain.workouts;

public class PushupWorkout extends BaseWorkout {

    public static final int PRIOD_OF_TIME_IN_MINUTES = 1;

    private int numOfPushups;


    public PushupWorkout() {
    }

    public PushupWorkout(int numOfPushups) {
        this.numOfPushups = numOfPushups;
    }



    public int getNumOfPushups() {
        return numOfPushups;
    }

    public void setNumOfPushups(int numOfPushups) {
        this.numOfPushups = numOfPushups;
    }

    @Override
    public String getDescription() {
        return "You have " + PRIOD_OF_TIME_IN_MINUTES + " minute/s to do your maximum\n" +
                "push-ups.\n\n" +
                "GOOD LUCK!";

    }

    @Override
    public String getWarmUpDescription() {
        return "";
    }
}
