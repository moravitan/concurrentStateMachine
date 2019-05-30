package Watching;

import Initial.On;
import main.File;

public abstract class WatchingRegion {

    protected boolean paused = false;
    protected On on;

    public WatchingRegion(On on) {
        this.on = on;
    }


    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

    public abstract void movieOn(File file);
    public abstract void downloadError();
    public abstract void errorFixed();
    public abstract void resume(File file);
    public abstract void holdMovie();
    public abstract void restartMovie();
    public abstract void internetOff();
    public abstract void internetOn();
    public abstract void doAction(File file);
    public abstract void movieOff();
}
