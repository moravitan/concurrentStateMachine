import java.util.concurrent.TimeUnit;

public class Download extends On implements IDownloading {

    private MovieDownloader movieDownloader;
    private File file;
    private RunnableDownload runnableDownload;
    private Thread thread;

    public Download(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
    }


    @Override
    public void downloadAborted() {
        this.runnableDownload.stop();
        movieDownloader.setDownloadingCurrent(movieDownloader.getDownloadingIdle());
        movieDownloader.getDisk().removeFile(file);
        System.out.println("exit [Download] state");
    }

    @Override
    public void errorFixed() {
        thread.start();
    }

    @Override
    public void downloadError() {
        System.out.println("enter [Error] state");


    }

    @Override
    public void doAction(File file) {
        this.file = file;
        this.runnableDownload = new RunnableDownload(this.file);
        thread = new Thread(runnableDownload);
        thread.start();
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
    public void internetOff() {
        super.internetOff();
    }

}

class RunnableDownload implements Runnable {

    private File file;
    private boolean interrupt;

    public RunnableDownload(File file) {
        this.file = file;
        this.interrupt = false;
    }

    @Override
    public void run() {
        while(!interrupt) {
            while (file.getStatus() < 100.0) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.setStatus(file.getStatus() + 10.0);
            }
        }

    }

    public void stop(){
        this.interrupt = true;
    }

}



