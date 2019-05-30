package Downloading;

import Disk.DiskRegion;
import Initial.On;
import main.File;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Error extends DownloadingRegion {

    boolean fixed;
    private RunnableError runnableError;

    public Error() {
        this.fixed = false;
    }

    @Override
    public void downloadAborted(File file) {


    }

    @Override
    public void errorFixed() throws InterruptedException {
        System.out.println("exit [Downloading.Error] state");
        super.setCurrentState(super.getDownload());
        super.getCurrentState().errorFixed();

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void doAction(File file) throws InterruptedException {
        runnableError = new RunnableError(this);
        Thread t = new Thread(runnableError);
        t.start();
        Random rand = new Random();
        TimeUnit.SECONDS.sleep(rand.nextInt(4));
        t.join();
        if (!fixed){
            movieDownloader.getUser().setPoints(movieDownloader.getUser().getPoints() - 1);
            movieDownloader.getDisk().removeFile(file);
            super.setCurrentState(super.getDownloadingIdle());
        }
        else{
            errorFixed();
        }
    }



    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    @Override
    public String toString() {
        return "[Downloading.Error]";
    }
}

class RunnableError implements Runnable{

    private Error error;

    public RunnableError(Error error) {
        this.error = error;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int time = rand.nextInt(2);
        if (time == 0){
            error.setFixed(true);
        }
        else{
            error.setFixed(false);
        }


    }
}