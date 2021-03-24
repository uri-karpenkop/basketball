package com.example.basketballtrain.workouts;

public class DribellingWorkout extends BaseWorkout {

    private int spider;
    private int slalom;
    private int tennisBall;
    private int running;

    public DribellingWorkout() {
    }

    public DribellingWorkout(int threeThrow, int insidePaintThrow, int freeThrow, int driveThrow) {
        this.spider = threeThrow;
        this.slalom = insidePaintThrow;
        this.tennisBall = freeThrow;
        this.running = driveThrow;
    }



    public int getSpider() {
        return spider;
    }

    public void setSpider(int threeThrow) {
        this.spider = threeThrow;
    }

    public int getSlalom() {
        return slalom;
    }

    public void setSlalom(int insidePaintThrow) {
        this.slalom = insidePaintThrow;
    }

    public int getTennisBall() {
        return tennisBall;
    }

    public void setTennisBall(int freeThrow) {
        this.tennisBall = freeThrow;
    }

    public int getRunning() {
        return running;
    }

    public void setRunning(int driveThrow) {
        this.running = driveThrow;
    }

    @Override
    public String getDescription() {
        return "This is the Dribbling desc";
    }
}
