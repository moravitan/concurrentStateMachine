package Connection;

import Initial.On;

public class Disconnected extends ConnectionRegion {

    public Disconnected(On on) {
        super(on);
    }

    @Override
    public void internetOn() {
        on.setConnected(true);
        System.out.println("exit [Disconnected] state");
        on.setConnectedCurrent(on.getConnected());
        System.out.println("enter [Connected] state");

    }



    @Override
    public void internetOff() {

    }

    @Override
    public String toString() {
        return "[Disconnected]";
    }
}
