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
        return "1. spider train for 3 minutes\n" +
                "2. bounce the ball in a slalom between your legs for 3 minutes.\n" +
                "3.bounce the ball and throw up the tennis ball in the other hand. change hand after 3 minutes\n" +
                "4.run as fast as you can while bouncing the ball and look to the other side you are from the hand you bounce of. do this 10 times.";
    }
}
