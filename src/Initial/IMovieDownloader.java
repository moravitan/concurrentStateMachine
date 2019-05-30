package Initial;

import main.File;

public interface IMovieDownloader {

    void turnOn();

    void turnOff();

    void internetOff();

    void internetOn();
    void fileRequest(File file);
    void downloadAborted(File file);
    void downloadError();
    void errorFixed();
    void restartMovie();


    void movieOn(File file);

    void holdMovie();

    void movieOff();

    void resume(File file);


    void doAction(File file);





}
