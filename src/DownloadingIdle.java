public class DownloadingIdle extends On implements IDownloading {

    private MovieDownloader movieDownloader;

    public DownloadingIdle(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void downloadError() {

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
}
