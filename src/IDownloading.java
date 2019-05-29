public interface IDownloading extends IInitial{

    void downloadAborted();
    void errorFixed();
    void downloadError();
    void doAction(File file) throws InterruptedException;


}
