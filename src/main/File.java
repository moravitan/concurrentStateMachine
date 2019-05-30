package main;

public class File {

    private int size;
    private double status;
    private double time;

    public File(int size) {
        this.size = size;
        this.status = 0.0;
    }

    public int getSize() {
        return size;
    }

    public double getStatus() {
        return status;
    }

    public double getTime() {
        return time;
    }

    public void setStatus(double status) {
        this.status = status;
    }
}
