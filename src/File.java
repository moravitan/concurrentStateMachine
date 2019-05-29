public class File {

    private int size;
    private double status;

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


    public void setStatus(double status) {
        this.status = status;
    }
}
