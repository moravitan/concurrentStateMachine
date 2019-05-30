package main;

public class User {

    public enum Status {BEGIN, ADVANCED, PRO}

    private Status status;
    private int points;
    private double speed;

    public User(Status status) {
        this.status = status;
        this.points = 0;
        speed = 1.2;
    }

    //<editor-fold desc="Getters">
    public Status getStatus() {
        return status;
    }

    public int getPoints() {
        return points;
    }

    public double getSpeed() {
        return speed;
    }



    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPoints(int points) {
        this.points = points;
        if (points < 4) {
            status = Status.BEGIN;
            setSpeed(1);
        }
        if (points >= 4 && points < 7) {
            status = Status.ADVANCED;
            setSpeed(1.2);
        }
        if (points >= 7){
            status = Status.PRO;
            setSpeed(1.5);
        }
    }

    private void setSpeed(double speed) {
        this.speed = speed;
    }
    //</editor-fold>
}
