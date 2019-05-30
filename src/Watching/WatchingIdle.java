package Watching;

import Initial.On;
import main.File;

public class WatchingIdle extends WatchingRegion {

    public WatchingIdle(On on) {
        super(on);
    }

    @Override
    public void movieOn(File file) {
        if (file.equals(on.getCurrentFileDownloading()) && file.getStatus() > 20.0){
            System.out.println("exit [Watching.WatchingIdle] state");
            on.setTime(0);
            System.out.println("enter [Watching.Watch] state");
            on.setWatchingCurrent(on.getWatch());
            on.getWatchingCurrent().doAction(file);
        }

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void resume(File file) {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void restartMovie() {

    }



    @Override
    public void internetOff() {
    }

    @Override
    public void internetOn() {

    }

    @Override
    public void doAction(File file) {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public String toString() {
        return "[WatchingIdle]";
    }
}
