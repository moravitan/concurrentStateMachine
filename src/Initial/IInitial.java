package Initial;

import main.File;

public interface IInitial{

    void turnOff();
    void turnOn();
    void internetOff();


    void movieOn(File file) throws InterruptedException;
    void downloadError() throws InterruptedException;
    void errorFixed() throws InterruptedException;
    void resume(File file) throws InterruptedException;
    void holdMovie();
    void restartMovie() throws InterruptedException;
    void insert(File file);
    void downloadAborted(File file);
    void doAction(File file) throws InterruptedException;
    void fileRequested(File file) throws InterruptedException;
    void internetOn();
    IInitial getCurrentState();
    void setCurrentState(IInitial currentState);


}
