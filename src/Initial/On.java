package Initial;

import Connection.*;
import Disk.*;
import Downloading.*;
import Downloading.Error;
import Queue.*;
import Status.StatusRegion;
import Watching.*;
import main.*;

public class On implements IInitial {

    protected MovieDownloader movieDownloader;
    protected Disk disk;
    protected boolean isConnected;
    protected File currentFileDownloading;
    protected int time;

    private IInitial diskRegion;
    private IInitial watchingRegion;
    private IInitial downloadingRegion;
    private IInitial queueRegion;
    private IInitial connectionRegion;
    private IInitial statusRegion;

    // current states
    private IInitial connectedCurrent;
    private IInitial queueCurrent;
    private IInitial watchingCurrent;
    private IInitial downloadingCurrent;
    private IInitial diskCurrent;
    private IInitial statusCurrent;

    public On() { }

    public On(MovieDownloader movieDownloader, Disk disk) {
        this.movieDownloader = movieDownloader;
        this.disk = disk;
        this.isConnected = false;
        this.diskRegion = new DiskRegion();
        this.watchingRegion = new WatchingRegion();
        this.downloadingRegion = new DownloadingRegion();
        this.queueRegion = new QueueRegion();
        this.connectionRegion = new ConnectionRegion();
        this.statusRegion = new StatusRegion();
        // update current states
        connectedCurrent = connectionRegion.getCurrentState();
        queueCurrent = queueRegion.getCurrentState();
        watchingCurrent = watchingRegion.getCurrentState();
        downloadingCurrent = downloadingRegion.getCurrentState();
        diskCurrent = diskRegion.getCurrentState();
        statusCurrent = statusRegion.getCurrentState();
    }

    public On(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }


    @Override
    public void turnOff() {
        movieDownloader.setInitialCurrent(movieDownloader.getOff());
    }

    @Override
    public void turnOn() {
        diskRegion.turnOn();
    }

    @Override
    public void internetOff() {
        movieDownloader.setInitialCurrent(movieDownloader.getOff());
    }


    @Override
    public void internetOn() {
        connectedCurrent.internetOn();
    }

    @Override
    public IInitial getCurrentState() {
        return null;
    }

    @Override
    public void setCurrentState(IInitial currentState) {

    }

    @Override
    public void fileRequested(File file) throws InterruptedException {
        if (isConnected) {
            diskCurrent.fileRequested(file);
        }
    }


    @Override
    public void downloadAborted(File file) {
        diskCurrent.downloadAborted(file);
    }

    @Override
    public void doAction(File file) throws InterruptedException {

    }

    @Override
    public void errorFixed() throws InterruptedException {
        if (watchingCurrent instanceof Watch) {
            watchingCurrent.downloadError();
        }
        downloadingCurrent.errorFixed();
    }

    @Override
    public void resume(File file) throws InterruptedException {
        watchingCurrent.resume(file);
    }

    @Override
    public void movieOn(File file) throws InterruptedException {
        watchingCurrent.movieOn(file);

    }

    @Override
    public void downloadError() throws InterruptedException {
        if (watchingCurrent instanceof Watch) {
            watchingCurrent.downloadError();
        }
        downloadingCurrent.downloadError();
    }

    @Override
    public void holdMovie() {
        watchingCurrent.holdMovie();

    }

    @Override
    public void restartMovie() throws InterruptedException {
        watchingCurrent.restartMovie();

    }

    @Override
    public void insert(File file) {
        diskCurrent.insert(file);
    }



    @Override
    public String toString() {
        return "enter " + connectedCurrent.toString() + " state" +
                "enter " + queueCurrent.toString() + " state" +
                "enter " + diskCurrent.toString() + " state" +
                "enter " + watchingCurrent.toString() + " state" +
                "enter [Begin] state";
    }

    //<editor-fold desc="Setters">


    public void setCurrentFileDownloading(File currentFileDownloading) {
        this.currentFileDownloading = currentFileDownloading;
    }

    public void setConnectedCurrent(IInitial connectedCurrent) {
        this.connectedCurrent = connectedCurrent;
    }

    public void setQueueCurrent(IInitial queueCurrent) {
        this.queueCurrent = queueCurrent;
    }

    public void setWatchingCurrent(IInitial watchingCurrent) {
        this.watchingCurrent = watchingCurrent;
    }

    public void setDownloadingCurrent(IInitial downloadingCurrent) {
        this.downloadingCurrent = downloadingCurrent;
    }

    public void setDiskCurrent(IInitial diskCurrent) {
        this.diskCurrent = diskCurrent;
    }

    public void setStatusCurrent(IInitial statusCurrent) {
        this.statusCurrent = statusCurrent;
    }

    //</editor-fold>


    //<editor-fold desc="getters">
    public MovieDownloader getMovieDownloader() {
        return movieDownloader;
    }

    public Disk getDisk() {
        return disk;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public File getCurrentFileDownloading() {
        return currentFileDownloading;
    }

    public int getTime() {
        return time;
    }

    public IInitial getDiskRegion() {
        return diskRegion;
    }

    public IInitial getWatchingRegion() {
        return watchingRegion;
    }

    public IInitial getDownloadingRegion() {
        return downloadingRegion;
    }

    public IInitial getQueueRegion() {
        return queueRegion;
    }

    public IInitial getConnectionRegion() {
        return connectionRegion;
    }

    public IInitial getConnectedCurrent() {
        return connectedCurrent;
    }

    public IInitial getQueueCurrent() {
        return queueCurrent;
    }

    public IInitial getWatchingCurrent() {
        return watchingCurrent;
    }

    public IInitial getDownloadingCurrent() {
        return downloadingCurrent;
    }

    public IInitial getDiskCurrent() {
        return diskCurrent;
    }

    public IInitial getStatusRegion() {
        return statusRegion;
    }

    public IInitial getStatusCurrent() {
        return statusCurrent;
    }

    //</editor-fold>
}
