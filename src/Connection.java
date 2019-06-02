public class Connection implements IMovieDownloader {


    private MovieDownloader movieDownloader;


    public Connection(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOff() {
        System.out.println("enter [Connection] state");
        this.movieDownloader.setConnected(false);
        System.out.println("exit [Connection state");
        if (this.movieDownloader.isOn()){
            System.out.println("enter [On] state");
            movieDownloader.setCurrentState(movieDownloader.getOn());
        }
        else{
            System.out.println("enter [Off] state");
            movieDownloader.setCurrentState(movieDownloader.getOff());
        }

    }

    @Override
    public void internetOn() {
        System.out.println("enter [Connection] state");
        this.movieDownloader.setConnected(true);
        System.out.println("exit [Connection] state");
        if (!this.movieDownloader.isOn()){
            System.out.println("enter [Off] state");
            movieDownloader.setCurrentState(movieDownloader.getOff());
        }
        else{
            System.out.println("enter [On] state");
            movieDownloader.setCurrentState(movieDownloader.getOn());
        }
    }

    @Override
    public void fileRequest(File file) {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }
}
