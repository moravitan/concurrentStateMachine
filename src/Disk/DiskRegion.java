package Disk;

import Initial.On;
import main.File;

public abstract class DiskRegion {

    protected On on;
    public DiskRegion(On on) {
        this.on = on;
    }

    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

    public abstract void fileRequest(File file);

    public abstract void doAction(File file);


}
