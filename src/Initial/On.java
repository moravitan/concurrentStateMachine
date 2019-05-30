package Initial;

import Connection.*;
import Disk.*;
import Downloading.*;
import Downloading.Error;
import Queue.*;
import Status.Advanced;
import Status.Begin;
import Status.Pro;
import Status.StatusRegion;
import Watching.*;
import main.*;

public class On implements IMovieDownloader {

    protected MovieDownloader movieDownloader;
    protected Disk disk;
    protected boolean isConnected;
    private File currentFileDownloading;
    protected int time;

    // all states
    private ConnectionRegion connected;
    private ConnectionRegion disconnected;
    // current state
    private DiskRegion diskIdle;
    private DiskRegion alert;
    private WatchingRegion watchingIdle;
    private WatchingRegion watch;
    private WatchingRegion pause;
    private DownloadingRegion downloadingIdle;
    private DownloadingRegion download;
    private DownloadingRegion error;
    private QueueRegion movieQueue;
    private StatusRegion begin;
    private StatusRegion advanced;
    private StatusRegion pro;

    // current states
    private ConnectionRegion connectedCurrent;
    private QueueRegion queueCurrent;
    private WatchingRegion watchingCurrent;
    private DownloadingRegion downloadingCurrent;
    private DiskRegion diskCurrent;
    private StatusRegion statusCurrent;

    public On() { }


    public On(MovieDownloader movieDownloader, Disk disk) {
        this.movieDownloader = movieDownloader;
        this.disk = disk;
        this.isConnected = false;
        this.connected = new Connected(this);
        this.disconnected = new Disconnected(this);
        this.diskIdle = new DiskIdle(this);
        this.alert = new Alert(this);
        this.downloadingIdle = new DownloadingIdle(this);
        this.download = new Download(this);
        this.error = new Error(this);
        this.movieQueue = new MovieQueue(this);
        this.begin = new Begin(this);
        this.advanced = new Advanced(this);
        this.pro = new Pro(this);
        this.watchingIdle = new WatchingIdle(this);
        this.watch = new Watch(this);
        this.pause = new Pause(this);

        // update current state
        this.connectedCurrent = disconnected;
        this.diskCurrent = diskIdle;
        this.downloadingCurrent = downloadingIdle;
        this.queueCurrent = movieQueue;
        this.watchingCurrent = watchingIdle;

        if(movieDownloader.getUser().getStatus() == User.Status.BEGIN)
            statusCurrent = begin;
        if(movieDownloader.getUser().getStatus() == User.Status.ADVANCED)
            statusCurrent = advanced;
        if(movieDownloader.getUser().getStatus() == User.Status.PRO)
            statusCurrent = pro;


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

    }

    @Override
    public void internetOff() {
        movieDownloader.setInitialCurrent(movieDownloader.getOff());
        if (downloadingCurrent instanceof Download){
            downloadingCurrent.internetOff();
        }
        if (watchingCurrent instanceof Watch){
            watchingCurrent.internetOff();
        }
    }


    @Override
    public void internetOn() {
        connectedCurrent.internetOn();
    }



    @Override
    public void fileRequest(File file){
        if (isConnected) {
            diskCurrent.fileRequest(file);
        }
    }


    @Override
    public void downloadAborted(File file) {
        if(isConnected) {
            downloadingCurrent.downloadAborted(file);
            queueCurrent.downloadAborted(file);
        }
    }

    @Override
    public void doAction(File file){

    }

    @Override
    public void errorFixed() {
        downloadingCurrent.errorFixed();
        watchingCurrent.downloadError();
    }

    @Override
    public void resume(File file) {
        watchingCurrent.resume(file);
    }

    @Override
    public void movieOn(File file) {
        watchingCurrent.movieOn(file);

    }

    @Override
    public void downloadError() {
        downloadingCurrent.downloadError();
        watchingCurrent.downloadError();
    }

    @Override
    public void holdMovie() {
        watchingCurrent.holdMovie();

    }

    @Override
    public void movieOff() {
        watchingCurrent.movieOff();
    }

    @Override
    public void restartMovie() {
        watchingCurrent.restartMovie();

    }



    @Override
    public String toString() {
        return "enter " + connectedCurrent.toString() + " state\n" +
                "enter " + queueCurrent.toString() + " state\n" +
                "enter " + diskCurrent.toString() + " state\n" +
                "enter " + watchingCurrent.toString() + " state\n" +
                "enter " + statusCurrent.toString() + " state";
    }

    //<editor-fold desc="Setters">

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setCurrentFileDownloading(File currentFileDownloading) {
        this.currentFileDownloading = currentFileDownloading;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setConnectedCurrent(ConnectionRegion connectedCurrent) {
        this.connectedCurrent = connectedCurrent;
    }

    public void setQueueCurrent(QueueRegion queueCurrent) {
        this.queueCurrent = queueCurrent;
    }

    public void setWatchingCurrent(WatchingRegion watchingCurrent) {
        this.watchingCurrent = watchingCurrent;
    }

    public void setDownloadingCurrent(DownloadingRegion downloadingCurrent) {
        this.downloadingCurrent = downloadingCurrent;
    }

    public void setDiskCurrent(DiskRegion diskCurrent) {
        this.diskCurrent = diskCurrent;
    }

    public void updateStatusCurrent() {
        StatusRegion temp = statusCurrent;
        if(movieDownloader.getUser().getStatus() == User.Status.BEGIN)
            statusCurrent = begin;
        if(movieDownloader.getUser().getStatus() == User.Status.ADVANCED)
            statusCurrent = advanced;
        if(movieDownloader.getUser().getStatus() == User.Status.PRO)
            statusCurrent = pro;

        if(!temp.equals(statusCurrent)){
            System.out.println("exit " + temp.toString() + " state");
            System.out.println("enter " + statusCurrent.toString() + " state");
        }

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

    public ConnectionRegion getConnected() {
        return connected;
    }

    public ConnectionRegion getDisconnected() {
        return disconnected;
    }

    public DiskRegion getDiskIdle() {
        return diskIdle;
    }

    public DiskRegion getAlert() {
        return alert;
    }

    public WatchingRegion getWatchingIdle() {
        return watchingIdle;
    }

    public WatchingRegion getWatch() {
        return watch;
    }

    public WatchingRegion getPause() {
        return pause;
    }

    public DownloadingRegion getDownloadingIdle() {
        return downloadingIdle;
    }

    public DownloadingRegion getDownload() {
        return download;
    }

    public DownloadingRegion getError() {
        return error;
    }

    public QueueRegion getMovieQueue() {
        return movieQueue;
    }

    public StatusRegion getBegin() {
        return begin;
    }

    public StatusRegion getAdvanced() {
        return advanced;
    }

    public StatusRegion getPro() {
        return pro;
    }

    public ConnectionRegion getConnectedCurrent() {
        return connectedCurrent;
    }

    public QueueRegion getQueueCurrent() {
        return queueCurrent;
    }

    public WatchingRegion getWatchingCurrent() {
        return watchingCurrent;
    }

    public DownloadingRegion getDownloadingCurrent() {
        return downloadingCurrent;
    }

    public DiskRegion getDiskCurrent() {
        return diskCurrent;
    }

    public StatusRegion getStatusCurrent() {
        return statusCurrent;
    }


    //</editor-fold>
}
