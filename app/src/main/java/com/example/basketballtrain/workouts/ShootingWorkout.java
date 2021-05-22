package com.example.basketballtrain.workouts;

public class ShootingWorkout extends BaseWorkout {

    private int threeThrow;
    private int insidePaintThrow;
    private int freeThrow;
    private int driveThrow;

    public ShootingWorkout() {
    }

    public ShootingWorkout(int threeThrow, int insidePaintThrow, int freeThrow, int driveThrow) {
        this.threeThrow = threeThrow;
        this.insidePaintThrow = insidePaintThrow;
        this.freeThrow = freeThrow;
        this.driveThrow = driveThrow;
    }



    public int getThreeThrow() {
        return threeThrow;
    }

    public void setThreeThrow(int threeThrow) {
        this.threeThrow = threeThrow;
    }

    public int getInsidePaintThrow() {
        return insidePaintThrow;
    }

    public void setInsidePaintThrow(int insidePaintThrow) {
        this.insidePaintThrow = insidePaintThrow;
    }

    public int getFreeThrow() {
        return freeThrow;
    }

    public void setFreeThrow(int freeThrow) {
        this.freeThrow = freeThrow;
    }

    public int getDriveThrow() {
        return driveThrow;
    }

    public void setDriveThrow(int driveThrow) {
        this.driveThrow = driveThrow;
    }

    @Override
    public String getDescription() {
        return "Shoot 10 times from tree\n" + "" +
                "Shoot 10 inside the paint\n" +
                "Shoot 10 free throw \n" +
                "Shoot 10 drive throw";

    }
}
