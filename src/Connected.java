public class Connected extends On implements IConnection {

    private MovieDownloader movieDownloader;


    public Connected(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void internetOn() {
        movieDownloader.setConnectedCurrent(movieDownloader.getConnected());
    }

    @Override
    public void turnOff() { super.turnOff(); }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void internetOff() { super.internetOff(); }


}
