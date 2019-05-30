package Disk;

import Initial.On;
import main.File;

public class DiskIdle extends DiskRegion {


    public DiskIdle(On on) {
        super(on);
    }

    @Override
    public void fileRequest(File file) {
        System.out.println("exit [DiskIdle] state");
        if (file.getSize() <= on.getDisk().getSpace()) {
            on.getDisk().addFile(file);
            System.out.println("exit [MovieQueue] state");
            System.out.println("enter [DiskIdle] state");
            on.getQueueCurrent().insert(file);
        }
        else if (file.getSize() > on.getDisk().getSpace()) {
            System.out.println("exit [DiskIdle] state");
            on.setDiskCurrent(on.getAlert());
            System.out.println("enter [Alert] state");
            on.getDiskCurrent().doAction(file);

        }
    }

    @Override
    public void doAction(File file) {

    }

    @Override
    public String toString() {
        return "[DiskIdle]";
    }
}
