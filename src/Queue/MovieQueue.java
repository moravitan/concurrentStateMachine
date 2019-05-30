package Queue;

import Downloading.Download;
import Downloading.DownloadingRegion;
import Initial.On;
import main.File;

import java.util.LinkedList;
import java.util.Queue;


public class MovieQueue extends QueueRegion {

    public static Queue<File> queue;

    public MovieQueue(On on) {
        super(on);
        this.queue = new LinkedList<>();
    }


    @Override
    public void insert(File file) {
        this.queue.add(file);
        System.out.println("enter [MovieQueue] state");
        if (on.isConnected() && !(on.getDownloadingCurrent() instanceof Download)){
            System.out.println("exit [DownloadingIdle] state");
            on.setDownloadingCurrent(on.getDownload());
            on.setCurrentFileDownloading(this.queue.poll());
            System.out.println("enter [Download] state");
            on.getDownloadingCurrent().doAction(on.getCurrentFileDownloading());
        }
    }

    @Override
    public void downloadAborted(File file) {
        System.out.println("exit [MovieQueue] state");
        on.getDisk().removeFile(file);
        on.setQueueCurrent(on.getMovieQueue());
        System.out.println("enter [Movie Queue] state");
    }



    @Override
    public String toString() {
        return "[MovieQueue]";
    }

}
