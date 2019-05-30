package Connection;

import Initial.*;
import main.File;

public class Connected extends ConnectionRegion {


    public Connected(){ }

    @Override
    public void internetOn() {
        System.out.println("This event isn't available from this state");
    }


    @Override
    public String toString() {
        return "[Connected]";
    }
}
