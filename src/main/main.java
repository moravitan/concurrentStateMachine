package main;

import Disk.Disk;

public class main {

    public static void main(String[] args) {
        User user = new User(User.Status.BEGIN);
        Disk disk  = new Disk();
        MovieDownloader movieDownloader = new MovieDownloader(user,disk);
    }
}
