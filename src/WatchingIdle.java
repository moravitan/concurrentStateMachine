public class WatchingIdle extends On implements IWatching {

    private MovieDownloader movieDownloader;

    public WatchingIdle(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void movieOn() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void restartMovie() {

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
