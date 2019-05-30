package Disk;

import main.File;

import java.util.LinkedList;
import java.util.Queue;

public class Disk {

    private int space;
    private Queue<File> files;

    public Disk() {
        space = 100;
        files = new LinkedList<>();
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    public Queue<File> getFiles() {
        return files;
    }

    public void addFile(File file) {
        files.add(file);
        space -= file.getSize();
    }

    public void removeFile(File file){
        files.remove(file);
        space += file.getSize();
    }


}

