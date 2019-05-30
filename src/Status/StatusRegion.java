package Status;

import Initial.On;
import main.User;

public abstract class StatusRegion {

    protected On on;
    protected User.Status status;

    public StatusRegion(On on) {
        this.on = on;
    }


    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StatusRegion){
            StatusRegion statusRegion = (StatusRegion) obj;
            return this.status == statusRegion.status;
        }
        return false;
    }
}
