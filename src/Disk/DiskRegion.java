package Disk;

import Initial.IInitial;
import Initial.On;

public class DiskRegion extends On {

    // all state
    private IInitial diskIdle;
    private IInitial alert;

    // current state
    private IInitial currentState;

    public DiskRegion() {
        this.diskIdle = new DiskIdle();
        this.alert = new Alert();
        // update current state
        this.currentState = diskIdle;
    }

    //<editor-fold desc="getters">
    public IInitial getDiskIdle() {
        return diskIdle;
    }

    public IInitial getAlert() {
        return alert;
    }

    @Override
    public IInitial getCurrentState() {
        return currentState;
    }
    //</editor-fold>


    @Override
    public void setCurrentState(IInitial currentState) {
        this.currentState = currentState;
        super.setDiskCurrent(currentState);
    }
}
