package Watching;

import Initial.On;
import main.File;

public class Pause extends WatchingRegion{

    private File file;
    public Pause(On on) {
        super(on);
    }

    @Override
    public void movieOn(File file) {
    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed()  {
        System.out.println("exit [Watching.Pause] state");
        on.setWatchingCurrent(on.getWatch());
        System.out.println("enter [Watching.Watch] state");
        on.getWatchingCurrent().doAction(file);
    }

    @Override
    public void resume(File file) {
        this.file = file;
        on.setWatchingCurrent(on.getWatch());
        on.getWatchingCurrent().doAction(file);
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
        if (paused){
            paused = false;
            System.out.println("exit [Pause] state");
            on.setWatchingCurrent(on.getWatch());
            System.out.println("enter [Watch] state");
        }
    }

    @Override
    public void doAction(File file) {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public String toString() {
        return "[Watching.Pause]";
    }
}
