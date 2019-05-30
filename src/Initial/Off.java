package Initial;

import main.File;
import main.MovieDownloader;

public class Off implements IInitial {

    private MovieDownloader movieDownloader;

    public Off(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void turnOff() {
        System.out.println("This event isn't available from this state");
    }

    @Override
    public void turnOn() {
        System.out.println("exit [Initial.Off] state");
        movieDownloader.setInitialCurrent(movieDownloader.getOn());

    }

    @Override
    public void internetOff() {
        System.out.println("This event isn't available from this state");
    }

    @Override
    public void internetOn() {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public IInitial getCurrentState() {
        return null;
    }

    @Override
    public void setCurrentState(IInitial currentState) {

    }

    @Override
    public void fileRequested(File file) {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void downloadAborted(File file) {
        System.out.println("This event isn't available from this state");


    }

    @Override
    public void doAction(File file) throws InterruptedException {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void errorFixed() {
        System.out.println("This event isn't available from this state");
    }

    @Override
    public void resume(File file) throws InterruptedException {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void movieOn(File file) {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void downloadError() throws InterruptedException {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void holdMovie() {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void restartMovie() {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public void insert(File file) {
        System.out.println("This event isn't available from this state");

    }

    @Override
    public String toString() {
        return "[Off]";
    }
}
