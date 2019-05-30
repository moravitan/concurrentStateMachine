package Status;

import Initial.On;
import main.User;

public class Begin extends StatusRegion {

    public Begin(On on) {
        super(on);
        status = User.Status.BEGIN;
    }

    @Override
    public String toString(){
        return "[Begin]";
    }
}
