import java.util.LinkedList;
import java.util.Queue;

public class MovieQueue extends On implements IQueue {

    private MovieDownloader movieDownloader;
    private Disk disk;
    private Queue<File> queue;

    public MovieQueue(MovieDownloader movieDownloader, Disk disk) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
        this.disk = disk;
        this.queue = new LinkedList<>();
    }

    @Override
    public void insert(File file) {
        disk.addFile(file);
        System.out.println("enter [Movie Queue] state");
    }

    @Override
    public void downloadAborted() {

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
