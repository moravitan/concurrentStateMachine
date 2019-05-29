public class MovieDownloader {

    private User user;
    private Disk disk;
    // all states
    private IInitial on;
    private IInitial off;
    private IConnection connected;
    private IConnection disconnected;
    private IQueue movieQueue;
    private IWatching watchingIdle;
    private IWatching watch;
    private IWatching pause;
    private IDownloading downloadingIdle;
    private IDownloading download;
    private IDownloading error;
    private IDisk diskIdle;
    private IDisk alert;

    // current states
    private IInitial initialCurrent;
    private IConnection connectedCurrent;
    private IQueue queueCurrent;
    private IWatching watchingCurrent;
    private IDownloading downloadingCurrent;
    private IDisk diskCurrent;


    public MovieDownloader(User user, Disk disk) throws InterruptedException {
        this.user = user;
        this.disk = disk;
        on = new On(this);
        off = new Off(this);
        connected = new Connected(this);
        disconnected = new Disconnected(this);
        movieQueue = new MovieQueue(this, disk);
        watchingIdle = new WatchingIdle(this);
        watch = new Watch(this);
        pause = new Pause(this);
        downloadingIdle = new DownloadingIdle(this);
        download = new Download(this);
        error = new Error(this);
        diskIdle = new DiskIdle(this,disk);
        alert = new Alert(this);

        initialCurrent = on;
        connectedCurrent = disconnected;
        queueCurrent = movieQueue;
        watchingCurrent = watchingIdle;
        downloadingCurrent = downloadingIdle;
        diskCurrent = diskIdle;

    }

    public void turnOn(){
        System.out.println("enter [Disconnected] state");
        System.out.println("enter [On] state");
        System.out.println("enter [Movie Queue] state");
        System.out.println("enter [Disk idle] state");
        System.out.println("enter [Watching idle] state");
    }

    public void InternetOn(){
        connectedCurrent.internetOn();
    }

    public void internetOff(){
        connectedCurrent.internetOff();
    }

    public void turnOff(){}


    public void fileRequested(File file){
        if (connectedCurrent instanceof  Connected) {
            diskCurrent.fileRequested(file);
        }

    }

    public void downloadAborted(){
        if (connectedCurrent instanceof Connected){
            downloadingCurrent.downloadAborted();
        }
    }

    public void errorFixed(){
        if (connectedCurrent instanceof Connected){
            downloadingCurrent.errorFixed();
            downloadingCurrent.errorFixed();

        }
    }






    //<editor-fold desc="Setters">


    public void setConnectedCurrent(IConnection connectedCurrent) {
        this.connectedCurrent = connectedCurrent;
    }

    public void setInitialCurrent(IInitial initialCurrent) {
        this.initialCurrent = initialCurrent;
    }

    public void setQueueCurrent(IQueue queueCurrent) {
        this.queueCurrent = queueCurrent;
    }

    public void setWatchingCurrent(IWatching watchingCurrent) {
        this.watchingCurrent = watchingCurrent;
    }

    public void setDownloadingCurrent(IDownloading downloadingCurrent) {
        this.downloadingCurrent = downloadingCurrent;
    }

    public void setDiskCurrent(IDisk diskCurrent) {
        this.diskCurrent = diskCurrent;
    }
    //</editor-fold>

    //<editor-fold desc="Getters">

    public User getUser() {
        return user;
    }

    public Disk getDisk() {
        return disk;
    }

    public IInitial getOn() {
        return on;
    }

    public IInitial getOff() {
        return off;
    }

    public IQueue getMovieQueue() {
        return movieQueue;
    }

    public IWatching getWatchingIdle() {
        return watchingIdle;
    }

    public IWatching getWatch() {
        return watch;
    }

    public IWatching getPause() {
        return pause;
    }

    public IDownloading getDownloadingIdle() {
        return downloadingIdle;
    }

    public IDownloading getDownload() {
        return download;
    }

    public IDownloading getError() {
        return error;
    }

    public IDisk getDiskIdle() {
        return diskIdle;
    }

    public IDisk getAlert() {
        return alert;
    }

    public IInitial getInitialCurrent() {
        return initialCurrent;
    }

    public IQueue getQueueCurrent() {
        return queueCurrent;
    }

    public IWatching getWatchingCurrent() {
        return watchingCurrent;
    }

    public IDisk getDiskCurrent() {
        return diskCurrent;
    }

    public IConnection getConnected() {
        return connected;
    }

    public IConnection getDisconnected() {
        return disconnected;
    }

    public IConnection getConnectedCurrent() {
        return connectedCurrent;
    }

    public IDownloading getDownloadingCurrent() {
        return downloadingCurrent;
    }

    //</editor-fold>
}

