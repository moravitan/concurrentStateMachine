package main;

import Disk.Disk;


public class main {

    public static void main(String[] args) {
        User user = new User(User.Status.BEGIN);
        Disk disk  = new Disk();
        MovieDownloader movieDownloader = new MovieDownloader(user,disk);
        File file1 = new File(50);
        File file2 = new File(40);
        File file3 = new File(30);
        File file4 = new File(10);
        File file5 = new File(10);
        File file6 = new File(10);
        File file7 = new File(10);
        movieDownloader.turnOn();
        movieDownloader.internetOn();
        movieDownloader.fileRequest(file1);
//        movieDownloader.fileRequest(file2);
//        movieDownloader.fileRequest(file3);
//        movieDownloader.movieOn(file2);
        movieDownloader.fileRequest(file4);
        movieDownloader.fileRequest(file5);
        movieDownloader.fileRequest(file6);

    }
}
