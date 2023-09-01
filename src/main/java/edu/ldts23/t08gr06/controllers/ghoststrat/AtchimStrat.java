package edu.ldts23.t08gr06.controllers.ghoststrat;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.model.Direction;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;

public class AtchimStrat extends GhostStrat {
    public AtchimStrat(Arena arena) {
        super(arena);
    }
    @Override
    public Position chasingTarget(Position position){
        if(arena.getPrincess().getDirection().equals(Direction.UP))
            return arena.getPrincess().getPosition().addDirection(Direction.UP.multiply(4)).addDirection(Direction.LEFT.multiply(4));
        else
            return arena.getPrincess().getPosition().addDirection(arena.getPrincess().getDirection().multiply(4));
    }}