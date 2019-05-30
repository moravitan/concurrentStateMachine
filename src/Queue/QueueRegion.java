package Queue;

import Initial.IInitial;
import Initial.On;

public class QueueRegion extends On {

    private IInitial currentState;


    public QueueRegion() {
        this.currentState = new MovieQueue();
    }

    @Override
    public IInitial getCurrentState() {
        return currentState;
    }

    @Override
    public void setCurrentState(IInitial currentState) {
        this.currentState = currentState;
    }
}
