public class On implements IInitial {

    private MovieDownloader movieDownloader;

    public On(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void turnOff() {
        movieDownloader.setInitialCurrent(movieDownloader.getOff());
    }

    @Override
    public void turnOn() {
        movieDownloader.setInitialCurrent(movieDownloader.getOn());

    }

    @Override
    public void internetOff() {
        movieDownloader.setInitialCurrent(movieDownloader.getOff());
    }
}
