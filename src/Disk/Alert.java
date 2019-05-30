package Disk;

import Initial.On;
import main.File;

import java.util.concurrent.TimeUnit;

public class Alert extends DiskRegion {

    public Alert() { }

    @Override
    public void doAction(File file) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        if (disk.getSpace() < file.getSize()) {
            disk.removeFile(file);
        } else {
            super.getQueueCurrent().insert(file);
            super.setQueueCurrent(super.getQueueRegion());
        }
        super.setCurrentState(super.getDiskIdle());

    }

    @Override
    public void fileRequested(File file) {
        System.out.println("This event isn't available from this state");
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
    public void internetOn() {
        super.internetOn();
    }

    @Override
    public String toString() {
        return "[Alert]";
    }
}
