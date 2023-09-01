package edu.ldts23.t08gr06.controllers.ghoststrat;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;

public class MestreStrat extends GhostStrat {
    public MestreStrat(Arena arena) {
        super(arena);
    }

    private Position MestreScatter() {
        return new Position(0, arena.getHeight() - 1);
    }

    @Override
    public Position chasingTarget(Position position) {
        return arena.getPrincess().getPosition().distance(position) >= 8 ? arena.getPrincess().getPosition() : MestreScatter();
    }

}
