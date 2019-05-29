import

public interface IWatching extends  IInitial {

    void movieOn();
    void downloadError();
    void errorFixed();
    void resume();
    void holdMovie();
    void restartMovie();
}
