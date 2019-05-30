package Watching;

import Initial.IInitial;
import Initial.On;
import main.File;

public class WatchingRegion extends On {

    // all states
    private IInitial watchingIdle;
    private IInitial watch;
    private IInitial pause;

    // current state
    private IInitial currentState;

    public WatchingRegion() {
        this.watchingIdle = new WatchingIdle();
        this.watch = new Watch();
        this.pause = new Pause();
        // update current state
        this.currentState = watchingIdle;
    }

    //<editor-fold desc="getters">
    public IInitial getWatchingIdle() {
        return watchingIdle;
    }

    public IInitial getWatch() {
        return watch;
    }

    public IInitial getPause() {
        return pause;
    }

    @Override
    public IInitial getCurrentState() {
        return currentState;
    }
    //</editor-fold>

    @Override
    public void setCurrentState(IInitial currentState) {
        this.currentState = currentState;
        super.setWatchingCurrent(currentState);
    }
}
