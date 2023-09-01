package edu.ldts23.t08gr06.model.game.elements.moveable;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.model.Direction;
import edu.ldts23.t08gr06.model.game.elements.Moveable;

public class Ghost extends Moveable{
    private GhostStrat strat;
    private GhostState state;
    public Ghost(int x, int y, Direction d, GhostState state){ super(x,y,d);
        this.state = state;
    }
    public GhostState getState() {
        return state;
    }
    public void setState(GhostState state) {
        this.state = state;
    }
    public void setStrat(GhostStrat st){this.strat=st;}
    public GhostStrat getStrat() {
        return strat;
    }

}
