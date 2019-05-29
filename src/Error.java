import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Error extends On implements IDownloading {

    private MovieDownloader movieDownloader;
    boolean fixed;
    private RunnableError runnableError;

    public Error(MovieDownloader movieDownloader) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
        fixed = false;

    }



    @Override
    public void downloadAborted() {


    }

    @Override
    public void errorFixed() {
        System.out.println("exit [Error] state");
        movieDownloader.setDownloadingCurrent(movieDownloader.getDownload());

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void doAction(File file) throws InterruptedException {
        runnableError = new RunnableError(this);
        Thread t = new Thread(runnableError);
        t.start();
        TimeUnit.SECONDS.sleep(3);
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


    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}

class RunnableError implements Runnable{

    private Error error;

    public RunnableError(Error error) {
        this.error = error;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int time = rand.nextInt(2);
        if (time == 0){
            error.setFixed(true);
            error.errorFixed();
        }
        else{
            error.setFixed(false);
        }


    }
}