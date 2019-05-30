package Downloading;

import Initial.On;
import main.File;
import Disk.Disk;

public class DownloadingIdle extends DownloadingRegion {

    private RunnableIdle runnableIdle;
    private Thread thread;

    public DownloadingIdle() {
        this.runnableIdle = new RunnableIdle(this,movieDownloader.getDisk());
        this.thread = new Thread(runnableIdle);
        thread.start();
    }



    @Override
    public String toString() {
        return "[DownloadingIdle]";
    }


}


class RunnableIdle implements Runnable{

    private volatile Disk disk;
    private volatile DownloadingRegion downloadingRegion;

    public RunnableIdle(DownloadingRegion downloadingRegion, Disk disk) {
        this.disk = disk;
        this.downloadingRegion = downloadingRegion;
    }

    @Override
    public void run() {
        while (disk.getFiles().size() > 0){
            File file = disk.getFiles().poll();
            this.downloadingRegion.setCurrentFileDownloading(file);
            this.downloadingRegion.setDownloadingCurrent(this.downloadingRegion.getDownload());
            try {
                this.downloadingRegion.getCurrentState().doAction(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}