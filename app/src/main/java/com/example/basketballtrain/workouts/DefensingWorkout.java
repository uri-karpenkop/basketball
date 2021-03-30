package com.example.basketballtrain.workouts;

public class DefensingWorkout extends BaseWorkout {

    private int tenTInesFour;
    private int slant;
    private int squat;
    private int lance;

    public DefensingWorkout() {
    }

    public DefensingWorkout(int tenTInesFour, int slant, int squat, int lance) {
        this.tenTInesFour = tenTInesFour;
        this.slant = slant;
        this.squat = squat;
        this.lance = lance;
    }



    public int getTenTInesFour() {
        return tenTInesFour;
    }

    public void setTenTInesFour(int tenTInesFour) {
        this.tenTInesFour = tenTInesFour;
    }

    public int getSlant() {
        return slant;
    }

    public void setSlant(int slant) {
        this.slant = slant;
    }

    public int getSquat() {
        return squat;
    }

    public void setSquat(int squat) {
        this.squat = squat;
    }

    public int getLance() {
        return lance;
    }

    public void setLance(int lance) {
        this.lance = lance;
    }

    @Override
    public String getDescription() {
        return "1. mark a distance of ten meters. and run this distance as fast as tou can twice in a row\n" +
                "2. Put one cone in the middle and four in alcoves from it.  You need to run in defense steps as fast as possible from the middle cone to the first cone and from there back to the middle and from there to the second and so on to the third and fourth and finally finish in the middle\n" +
                "3. most squat in 1 minutes\n" +
                "4. most lance in 1 minutes";
    }
}
