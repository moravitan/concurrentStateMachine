public class Disconnected extends On implements IConnection {

    private MovieDownloader movieDownloader;

    public Disconnected(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void internetOn() {
        System.out.println("exit [Disconnected] state");
        movieDownloader.setConnectedCurrent(movieDownloader.getConnected());
        System.out.println("enter [Connected] state");

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
