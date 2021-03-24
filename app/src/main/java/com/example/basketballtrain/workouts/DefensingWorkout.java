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
        return "This is the Defensing desc";
    }
}
