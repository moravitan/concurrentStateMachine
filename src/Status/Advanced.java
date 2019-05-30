package Status;

import Initial.On;
import main.User;

public class Advanced extends StatusRegion {


    public Advanced(On on) {
        super(on);
        status = User.Status.ADVANCED;
    }

    @Override
    public String toString(){
        return "[Advanced]";
    }
}
