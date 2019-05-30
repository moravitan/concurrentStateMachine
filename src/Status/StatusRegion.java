package Status;

import Initial.IInitial;
import Initial.On;
import main.User;

public class StatusRegion extends On {

    // all states
    private IInitial begin;
    private IInitial advanced;
    private IInitial pro;

    // current state
    private IInitial currentState;

    public StatusRegion() {
        this.begin = new Begin();
        this.advanced = new Advanced();
        this.pro = new Pro();

        if(movieDownloader.getUser().getStatus() == User.Status.BEGIN)
            this.currentState = begin;
        if(movieDownloader.getUser().getStatus() == User.Status.ADVANCED)
            this.currentState = advanced;
        if(movieDownloader.getUser().getStatus() == User.Status.PRO){
            this.currentState = pro;
        }
    }


    //<editor-fold desc="getters">
    public IInitial getBegin() {
        return begin;
    }

    public IInitial getAdvanced() {
        return advanced;
    }

    public IInitial getPro() {
        return pro;
    }

    @Override
    public IInitial getCurrentState() {
        return currentState;
    }
    //</editor-fold>


    @Override
    public void setCurrentState(IInitial currentState) {
        if(movieDownloader.getUser().getStatus() == User.Status.BEGIN)
            this.currentState = begin;
        if(movieDownloader.getUser().getStatus() == User.Status.ADVANCED)
            this.currentState = advanced;
        if(movieDownloader.getUser().getStatus() == User.Status.PRO){
            this.currentState = pro;
        }
        super.setStatusCurrent(this.currentState);

    }


}
