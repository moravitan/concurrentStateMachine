package Downloading;

import Initial.IInitial;
import Initial.On;

public class DownloadingRegion extends On {

    // all states
    private IInitial downloadingIdle;
    private IInitial download;
    private IInitial error;

    // current state
    private IInitial currentState;

    public DownloadingRegion() {
        this.downloadingIdle = new DownloadingIdle();
        this.download = new Download();
        this.error = new Error();
        // update current state
        this.currentState = downloadingIdle;
    }

    //<editor-fold desc="getters">
    @Override
    public IInitial getCurrentState() {
        return currentState;
    }

    public IInitial getDownloadingIdle() {
        return downloadingIdle;
    }

    public IInitial getDownload() {
        return download;
    }

    public IInitial getError() {
        return error;
    }
    //</editor-fold>


    @Override
    public void setCurrentState(IInitial currentState) {
        this.currentState = currentState;
        super.setDownloadingCurrent(currentState);
    }
}
