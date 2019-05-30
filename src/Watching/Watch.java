package Watching;

import Downloading.DownloadingIdle;
import Initial.On;
import main.File;

public class Watch extends WatchingRegion {


    private File file;

    public Watch(On on) {
        super(on);
        paused = false;
    }

    @Override
    public void movieOn(File file) {

    }

    @Override
    public void downloadError() {
        on.setWatchingCurrent(on.getPause());
    }

    @Override
    public void errorFixed() {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void resume(File file) {
        System.out.println("This event isn't available from this state");
    }

    @Override
    public void holdMovie() {
        System.out.println("exit [Watching.Watch] state");
        on.setWatchingCurrent(on.getPause());
    }

    @Override
    public void restartMovie() {
        System.out.println("exit [Watching.Watch] state");
        on.setTime(0);
        on.setWatchingCurrent(on.getWatch());
        on.getWatchingCurrent().doAction(this.file);

    }

    @Override
    public void doAction(File file) {
        this.file = file;
        while (on.getTime() < file.getTime() && !paused && file.getStatus() < 100.0
                && (on.getDownloadingCurrent() instanceof DownloadingIdle)) {
            on.setTime(on.getTime() + 1);
        }
        if (on.getDownloadingCurrent() instanceof DownloadingIdle) {
            on.setWatchingCurrent(on.getWatchingIdle());
        }


    }

    @Override
    public void movieOff() {
        System.out.println("exit [Watch] state");
        on.setWatchingCurrent(on.getWatchingIdle());
        System.out.println("enter [WatchingIdle] state");
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
        this.paused = true;
        System.out.println("exit [Watch] state");
        on.setWatchingCurrent(on.getPause());
        System.out.println("enter [Pause] state");
    }

    @Override
    public void internetOn() {

    }

    @Override
    public String toString() {
        return "[Watch]";
    }
}
