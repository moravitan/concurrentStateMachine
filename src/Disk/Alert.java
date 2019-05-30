package Disk;


import Initial.On;
import main.File;

import java.util.concurrent.TimeUnit;

public class Alert extends DiskRegion {


    public Alert(On on) {
        super(on);
    }

    @Override
    public void doAction(File file)  {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) { }
        if (on.getDisk().getSpace() < file.getSize()) {
            on.getDisk().removeFile(file);
        } else {
            on.getQueueCurrent().insert(file);
            on.setQueueCurrent(on.getMovieQueue());
        }
        System.out.println("exit [Alert] state");
        on.setDiskCurrent(on.getDiskIdle());
        System.out.println("enter [DiskIdle] state");

    }

    @Override
    public void fileRequest(File file) {
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
    public String toString() {
        return "[Alert]";
    }
}
