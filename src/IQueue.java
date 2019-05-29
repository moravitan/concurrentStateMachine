public interface IQueue extends IInitial {

    void insert(File file);

    void downloadAborted();
}
