public class Alert extends On implements IDisk {

    private MovieDownloader movieDownloader;

    public Alert(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void fileRequested(File file) {

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
