package Disk;

import main.File;

public class DiskIdle extends DiskRegion {

    public DiskIdle() {
    }

    @Override
    public void fileRequested(File file) throws InterruptedException {
        if (file.getSize() <= disk.getSpace()) {
            super.getQueueCurrent().insert(file);
        }
        if (file.getSize() > disk.getSpace()) {
            System.out.println("exit [DiskIdle] state");
            super.setCurrentState(super.getAlert());
            Thread t = new Thread(){
                public void run() {
                    try {
                        // TODO : check
                        DiskIdle.super.getCurrentState().doAction(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();


        }
    }


    @Override
    public String toString() {
        return "[DiskIdle]";
    }
}
