package main;

import Initial.IInitial;
import Disk.Disk;
import Initial.Off;
import Initial.On;

public class MovieDownloader {

    private User user;
    private Disk disk;
    // all states
    private IInitial on;
    private IInitial off;

    // current states
    private IInitial initialCurrent;


    public MovieDownloader(User user, Disk disk) {
        this.user = user;
        this.disk = disk;
        on = new On(this, disk);
        off = new Off(this);
        initialCurrent = off;

        System.out.println("enter [Initial.Off] state");


    }

    public void turnOn() {
        initialCurrent.turnOn();
        System.out.println(initialCurrent.toString());
    }

    public void InternetOn() {
        initialCurrent.internetOn();
    }

    public void internetOff() {
        initialCurrent.internetOff();
    }

    public void turnOff() {
        initialCurrent.turnOff();
    }


    public void fileRequested(File file) throws InterruptedException {
        initialCurrent.fileRequested(file);
    }

    public void downloadAborted(File file) {
        initialCurrent.downloadAborted(file);
    }

    public void errorFixed() throws InterruptedException {
        initialCurrent.errorFixed();
    }

    public void movieOn(File file) throws InterruptedException {
        initialCurrent.movieOn(file);
    }

    public void downloadError() throws InterruptedException {
        initialCurrent.downloadError();
    }

    public void holdMovie(){
        initialCurrent.holdMovie();
    }

    public void restartMovie() throws InterruptedException {
        initialCurrent.restartMovie();
    }


    //<editor-fold desc="Getters">
    public User getUser() {
        return user;
    }

    public Disk getDisk() {
        return disk;
    }

    public IInitial getOn() {
        return on;
    }

    public IInitial getOff() {
        return off;
    }

    public IInitial getInitialCurrent() {
        return initialCurrent;
    }
    //</editor-fold>


    //<editor-fold desc="Setters">
    public void setUser(User user) {
        this.user = user;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void setOn(IInitial on) {
        this.on = on;
    }

    public void setOff(IInitial off) {
        this.off = off;
    }

    public void setInitialCurrent(IInitial initialCurrent) {
        this.initialCurrent = initialCurrent;
    }
    //</editor-fold>
}

