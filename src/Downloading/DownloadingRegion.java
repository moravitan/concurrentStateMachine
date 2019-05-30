package Downloading;

import Initial.On;
import main.File;

public abstract class DownloadingRegion {

    protected boolean paused;
    protected File file;
    protected On on;

    public DownloadingRegion(On on) {
        this.on = on;
    }


    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

    public File getFile() {
        return file;
    }

    public abstract void downloadAborted(File file);
    public abstract void downloadError();
    public abstract void errorFixed();
    public abstract void internetOff();
    public abstract void internetOn();
    public abstract void doAction(File file);



}
