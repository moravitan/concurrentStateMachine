package Connection;

import Initial.*;
import main.File;

public class Connected extends ConnectionRegion {


    public Connected(On on) {
        super(on);
    }

    @Override
    public void internetOn() {
    }

    @Override
    public void internetOff(){
        on.setConnected(false);
        System.out.println("exit [Connected] state");
        on.setConnectedCurrent(on.getDisconnected());
        System.out.println("enter [Disconnected] state");

    }



    @Override
    public String toString() {
        return "[Connected]";
    }
}
