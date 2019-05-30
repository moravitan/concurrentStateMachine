package Initial;

import main.File;
import main.MovieDownloader;

public class Off implements IMovieDownloader {

    private MovieDownloader movieDownloader;

    public Off(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }


    @Override
    public void turnOn() {
        System.out.println("exit [Off] state");
        movieDownloader.setInitialCurrent(movieDownloader.getOn());
        System.out.println("enter [On] state");

    }

    @Override
    public void turnOff() {

    }


    @Override
    public void internetOff() {

    }

    @Override
    public void movieOn(File file)  {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed()  {

    }

    @Override
    public void resume(File file) {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void restartMovie() {

    }


    @Override
    public void downloadAborted(File file) {

    }

    @Override
    public void doAction(File file) {

    }

    @Override
    public void fileRequest(File file) {

    }

    @Override
    public void internetOn() {

    }



    @Override
    public String toString() {
        return "[Off]";
    }
}
