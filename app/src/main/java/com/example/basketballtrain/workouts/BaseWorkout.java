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
        return "WARM UP:\n" +
                " easy run\n" +
                "running whit knees to chest\n" +
                "running whit heels to breech\n" +
                "head, shoulders, wrist, waist, knee rotations\n" +
                "";
    }

}
