package Queue;

import Disk.DiskRegion;
import Initial.On;
import main.File;


public class MovieQueue extends QueueRegion {


    public MovieQueue() { }


    @Override
    public void insert(File file) {
        disk.addFile(file);
        System.out.println("enter [Movie Queue] state");
    }

    @Override
    public void downloadAborted(File file) {
        System.out.println("exit [Movie Queue] state");
        disk.removeFile(file);
        super.setCurrentState(super.getCurrentState());
        System.out.println("enter [Movie Queue] state");
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void internetOff() {
        super.internetOff();
    }

    @Override
    public String toString() {
        return "[Queue.MovieQueue]";
    }

}
