package Queue;

import Initial.On;
import main.File;

public abstract class QueueRegion {


    protected On on;

    public QueueRegion(On on) {
        this.on = on;
    }


    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

    public abstract void insert(File file);
    public abstract void downloadAborted(File file);

}
