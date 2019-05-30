package Downloading;

import Initial.On;
import Queue.MovieQueue;
import Watching.WatchingIdle;
import main.File;

public class Download extends DownloadingRegion {



    public Download(On on){
        super(on);
        paused = false;
    }


    @Override
    public void downloadAborted(File file) {
        on.getMovieDownloader().getUser().setPoints(on.getMovieDownloader().getUser().getPoints() - 1);
        on.updateStatusCurrent();
        on.getMovieDownloader().getDisk().removeFile(file);
        System.out.println("exit [Downloading] state");
        on.setDownloadingCurrent(on.getDownloadingIdle());
        System.out.println("enter [DownloadingIdle] state");
        if (!(on.getWatchingCurrent() instanceof WatchingIdle)){

        }
    }

    @Override
    public void errorFixed() {
    }

    @Override
    public void downloadError() {
        System.out.println("exit [Download] state");
        on.setDownloadingCurrent(on.getError());
        System.out.println("enter [Error] state");
        on.getDownloadingCurrent().doAction(file);


    }

    @Override
    public void doAction(File file) {
        on.setCurrentFileDownloading(file);
        this.file = file;
        while (file.getStatus() < 100.0) {
            file.setStatus(file.getStatus() + on.getMovieDownloader().getUser().getSpeed());
        }
        if (file.getStatus() >= 100.0){
            on.setCurrentFileDownloading(null);
            on.getMovieDownloader().getUser().setPoints(on.getMovieDownloader().getUser().getPoints() + 1);
            on.updateStatusCurrent();
            System.out.println("exit [Download] state");
            on.setDownloadingCurrent(on.getDownloadingIdle());
            System.out.println("enter [DownloadIdle] state");
        }
        if (on.isConnected() && MovieQueue.queue.size() > 0){
            System.out.println("exit [DownloadIdle] state");
            on.setDownloadingCurrent(on.getDownload());
            on.setCurrentFileDownloading(MovieQueue.queue.poll());
            System.out.println("enter [Download] state");
            on.getDownloadingCurrent().doAction(on.getCurrentFileDownloading());
        }
    }



    @Override
    public void internetOff() {
        this.paused = true;
        System.out.println("exit [Download] state");
        on.setDownloadingCurrent(on.getDownloadingIdle());
        System.out.println("enter [DownloadingIdle] state");
    }

    @Override
    public void internetOn() {
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
    public String toString() {
        return "[Downloading]";
    }


}




