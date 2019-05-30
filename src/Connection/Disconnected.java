package Connection;

import Initial.On;

public class Disconnected extends ConnectionRegion {


    public Disconnected(){ }

    @Override
    public void internetOn() {
        isConnected = true;
        System.out.println("exit [Disconnected] state");
        super.setCurrentState(super.getConnected());
        System.out.println("enter [Connected] state");

    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void internetOff() {
        super.internetOff();
    }

    @Override
    public String toString() {
        return "[Disconnected]";
    }
}
