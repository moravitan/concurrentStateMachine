public class User {

    public enum Status {ACTIVE, ADVANCED, PRO}
    private Status status;
    private int points;

    public User(Status status) {
        this.status = status;
        this.points = 0;
    }

    //<editor-fold desc="Getters">
    public Status getStatus() {
        return status;
    }

    public int getPoints() {
        return points;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    //</editor-fold>
}
