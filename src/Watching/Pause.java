package Watching;

import Initial.On;
import main.File;

public class Pause extends WatchingRegion{

    private File file;
    public Pause() { }

    @Override
    public void movieOn(File file) {
        System.out.println("This event isn't available from this state");
    }

    @Override
    public void downloadError() {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void errorFixed() throws InterruptedException {
        System.out.println("exit [Watching.Pause] state");
        super.setWatchingCurrent(super.getWatch());
        System.out.println("enter [Watching.Watch] state");
        super.getCurrentState().doAction(file);
    }

    @Override
    public void resume(File file) throws InterruptedException {
        this.file = file;
        super.setWatchingCurrent(super.getWatch());
        super.getCurrentState().doAction(file);
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
        return "[Watching.Pause]";
    }
}
