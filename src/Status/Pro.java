package Status;

import Initial.On;
import main.User;

public class Pro extends StatusRegion {

    public Pro(On on) {
        super(on);
        status = User.Status.PRO;
    }

    @Override
    public String toString(){
        return "[Pro]";
    }
}
