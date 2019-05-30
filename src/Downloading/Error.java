package Downloading;

import Initial.On;
import main.File;

import java.util.Random;

public class Error extends DownloadingRegion {

    boolean fixed;

    public Error(On on) {
        super(on);
        this.fixed = false;
    }

    @Override
    public void downloadAborted(File file) {


    }

    @Override
    public void errorFixed() {
        System.out.println("exit [Downloading.Error] state");
        on.setDownloadingCurrent(on.getDownload());
        on.getDownloadingCurrent().errorFixed();

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void doAction(File file) {
        Random rand = new Random();
        int time = rand.nextInt(2);
        if (time == 0) {
            fixed = true;
        } else {
            fixed = false;
        }
        time = rand.nextInt(6);
        if (!fixed && time < 3) {
            on.getMovieDownloader().getUser().setPoints(on.getMovieDownloader().getUser().getPoints() - 1);
            on.getMovieDownloader().getDisk().removeFile(file);
            on.setDownloadingCurrent(on.getDownloadingIdle());
        } else {
            errorFixed();
        }
    }

    @Override
    public void internetOff() {
    }

    @Override
    public void internetOn() {

    }


    @Override
    public String toString() {
        return "[Downloading.Error]";
    }
}
