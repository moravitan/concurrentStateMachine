package Downloading;

import Initial.On;
import main.File;
import Disk.Disk;

public class DownloadingIdle extends DownloadingRegion {


    public DownloadingIdle(On on) {
        super(on);
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
    public void downloadAborted(File file) {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void internetOn() {
        if (paused){
            System.out.println("exit [DownloadingIdle] state");
            on.setWatchingCurrent(on.getWatch());
            System.out.println("enter [Download] state");
        }
    }

    @Override
    public void doAction(File file) {

    }

    @Override
    public String toString() {
        return "[DownloadingIdle]";
    }


}
