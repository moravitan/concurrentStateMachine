package Watching;

import main.File;

public class WatchingIdle extends WatchingRegion {

    public WatchingIdle() { }

    @Override
    public void movieOn(File file) throws InterruptedException {
        if (file.equals(super.getCurrentFileDownloading()) && file.getStatus() > 20.0){
            System.out.println("exit [Watching.WatchingIdle] state");
            time = 0;
            System.out.println("enter [Watching.Watch] state");
            super.setCurrentState(super.getWatch());
            super.getCurrentState().doAction(file);
        }

    }

    @Override
    public void downloadError() {
        System.out.println("This event isn't available from this state");

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
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void restartMovie() {
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
    public String toString() {
        return "[WatchingIdle]";
    }
}
