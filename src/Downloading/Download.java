package Downloading;

import main.File;

public class Download extends DownloadingRegion {

    private File file;
    private RunnableDownload runnableDownload;
    private Thread thread;

    public Download(){}


    @Override
    public void downloadAborted(File file) {
        this.runnableDownload.stop();
        movieDownloader.getUser().setPoints(movieDownloader.getUser().getPoints() - 1);
        super.getStatusRegion().setCurrentState(null);
        movieDownloader.getDisk().removeFile(file);
        super.setCurrentState(super.getDownloadingIdle());
        System.out.println("exit [Downloading] state");
    }

    @Override
    public void errorFixed() {
        thread.start();

    }

    @Override
    public void downloadError() throws InterruptedException {
        runnableDownload.stop();
        System.out.println("enter [Error] state");
        super.setCurrentState(super.getError());
        super.getCurrentState().doAction(file);


    }

    @Override
    public void doAction(File file) throws InterruptedException {
        super.setCurrentFileDownloading(file);
        this.file = file;
        this.runnableDownload = new RunnableDownload(this.file, movieDownloader.getUser().getSpeed());
        thread = new Thread(runnableDownload);
        thread.start();
        thread.join();
        if (file.getStatus() == 100.0){
            super.setCurrentFileDownloading(null);
            movieDownloader.getUser().setPoints(movieDownloader.getUser().getPoints() + 1);
            super.getStatusRegion().setCurrentState(null);
            super.setCurrentState(super.getDownloadingIdle());
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
        return "[Downloading]";
    }

    public File getFile() {
        return file;
    }
}

class RunnableDownload implements Runnable {

    private File file;
    private double speed;
    private volatile boolean interrupt;

    public RunnableDownload(File file, double speed) {
        this.file = file;
        this.interrupt = false;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(!interrupt) {
            while (file.getStatus() < 100.0) {
                file.setStatus(file.getStatus() + speed);
            }
        }
    }

    public void stop(){
        this.interrupt = true;
    }



}



