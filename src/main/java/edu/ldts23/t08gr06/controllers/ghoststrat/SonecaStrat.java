package edu.ldts23.t08gr06.controllers.ghoststrat;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;

public class SonecaStrat extends GhostStrat {
    public SonecaStrat(Arena arena) {
        super(arena);
    }
    @Override
    public Position chasingTarget(Position position) {
        return arena.getPrincess().getPosition();
    }

}
