package Watching;

import Downloading.DownloadingIdle;
import Initial.On;
import main.File;

public class Watch extends WatchingRegion {

    private RunnableWatch runnableWatch;
    private Thread thread;
    private File file;

    public Watch() {
    }

    @Override
    public void movieOn(File file) {

    }

    @Override
    public void downloadError() {
        super.setWatchingCurrent(super.getPause());
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
        runnableWatch.holdMovie();
        super.setCurrentState(super.getPause());
    }

    @Override
    public void restartMovie() throws InterruptedException {
        System.out.println("exit [Watching.Watch] state");
        time = 0;
        super.setWatchingCurrent(super.getWatch());
        super.getWatchingCurrent().doAction(this.file);

    }

    @Override
    public void doAction(File file) throws InterruptedException {
        this.file = file;
        runnableWatch = new RunnableWatch(this, file, time);
        thread = new Thread(runnableWatch);
        thread.start();
        thread.join();
        if (super.getDownloadingCurrent() instanceof DownloadingIdle){
            super.setCurrentState(super.getWatchingIdle());
        }


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
        return "[Watch]";
    }
}

class RunnableWatch implements Runnable {

    private volatile On on;
    private volatile File file;
    private double time;
    private volatile boolean paused;


    public RunnableWatch(On on, File file, double time) {
        this.file = file;
        this.time = time;
        this.paused = false;
        this.on = on;
    }

    @Override
    public void run() {
        while (time < file.getTime() && !paused && file.getStatus() < 100.0
                && (this.on.getDownloadingCurrent() instanceof DownloadingIdle)) {
            time++;
        }
    }

    public void holdMovie() {
        paused = true;

    }


}