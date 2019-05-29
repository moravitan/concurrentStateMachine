public class DiskIdle extends On implements IDisk {

    private MovieDownloader movieDownloader;
    private Disk disk;


    public DiskIdle(MovieDownloader movieDownloader, Disk disk) {
        super(movieDownloader);
        this.movieDownloader = movieDownloader;
        this.disk = disk;
    }

    @Override
    public void fileRequested(File file) {
        if (file.getSize() <= disk.getSpace()) {
            movieDownloader.getQueueCurrent().insert(file);
        }
        if (file.getSize() > disk.getSpace()) {
            System.out.println("exit [Disk idle] state");
            movieDownloader.setDiskCurrent(movieDownloader.getAlert());
            System.out.println("enter [Disk Alert] state");
        }
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void internetOff() {

    }
}
