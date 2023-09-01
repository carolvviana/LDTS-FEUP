package edu.ldts23.t08gr06.controllers.ghoststrat;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.model.Direction;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;

public class DengosoStrat extends GhostStrat {
    public DengosoStrat(Arena arena) {
        super(arena);
    }
    @Override
    public Position chasingTarget(Position position) {
        Position target;
        if(arena.getPrincess().getDirection().equals(Direction.UP))
            target = arena.getPrincess().getPosition().addDirection(Direction.UP.multiply(2)).addDirection(Direction.LEFT.multiply(2));
        else
            target = arena.getPrincess().getPosition().addDirection(arena.getPrincess().getDirection().multiply(2));

        return target;
    }
}
