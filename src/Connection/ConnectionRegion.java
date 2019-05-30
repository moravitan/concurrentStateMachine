package Connection;

import Initial.IInitial;
import Initial.On;

public class ConnectionRegion extends On {

    // all states
    private IInitial connected;
    private IInitial disconnected;
    // current state
    private IInitial currentState;

    public ConnectionRegion() {
        this.connected = new Connected();
        this.disconnected = new Disconnected();
        // update current
        this.currentState = disconnected;
    }

    //<editor-fold desc="getters">
    public IInitial getConnected() {
        return connected;
    }

    public IInitial getDisconnected() {
        return disconnected;
    }

    @Override
    public IInitial getCurrentState() {
        return currentState;
    }
    //</editor-fold>


    @Override
    public void setCurrentState(IInitial currentState) {
        this.currentState = currentState;
        super.setConnectedCurrent(currentState);
    }
}
