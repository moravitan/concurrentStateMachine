package Connection;

import Initial.On;

public abstract class ConnectionRegion {


    protected On on;

    public ConnectionRegion(On on) {
        this.on = on;
    }

    public abstract void internetOn();
    public abstract void internetOff();

    public void turnOff() {
        on.turnOff();
    }

    public void turnOn() {
        on.turnOn();
    }

}
