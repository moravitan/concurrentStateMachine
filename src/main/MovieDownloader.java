package main;

import Initial.IMovieDownloader;
import Disk.Disk;
import Initial.Off;
import Initial.On;
import main.File;
import main.User;

public class MovieDownloader {

    private User user;
    private Disk disk;
    // all states
    private IMovieDownloader on;
    private IMovieDownloader off;

    // current states
    private IMovieDownloader initialCurrent;


    public MovieDownloader(User user, Disk disk) {
        this.user = user;
        this.disk = disk;
        on = new On(this, disk);
        off = new Off(this);
        initialCurrent = off;

        System.out.println("enter [Off] state");


    }

    public void turnOn() {
        initialCurrent.turnOn();
        System.out.println(initialCurrent.toString());
    }

    public void internetOn() {
        initialCurrent.internetOn();
    }

    public void internetOff() {
        initialCurrent.internetOff();
    }

    public void turnOff() {
        initialCurrent.turnOff();
    }


    public void fileRequest(File file)  {
        initialCurrent.fileRequest(file);
    }

    public void downloadAborted(File file) {
        initialCurrent.downloadAborted(file);
    }

    public void errorFixed() {
        initialCurrent.errorFixed();
    }

    public void movieOn(File file)  {
        initialCurrent.movieOn(file);
    }

    public void downloadError()  {
        initialCurrent.downloadError();
    }

    public void holdMovie(){
        initialCurrent.holdMovie();
    }

    public void restartMovie() {
        initialCurrent.restartMovie();
    }

    public void resume(File file){
        initialCurrent.resume(file);
    }

    public void movieOff(){
        initialCurrent.movieOff();
    }


    //<editor-fold desc="Getters">
    public User getUser() {
        return user;
    }

    public Disk getDisk() {
        return disk;
    }

    public IMovieDownloader getOn() {
        return on;
    }

    public IMovieDownloader getOff() {
        return off;
    }

    public IMovieDownloader getInitialCurrent() {
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

    public void setOn(IMovieDownloader on) {
        this.on = on;
    }

    public void setOff(IMovieDownloader off) {
        this.off = off;
    }

    public void setInitialCurrent(IMovieDownloader initialCurrent) {
        this.initialCurrent = initialCurrent;
    }
    //</editor-fold>
}

