package edu.ldts23.t08gr06.controllers.gamecontroller;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.GhostState;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public abstract class GhostStrat{
    protected Arena arena;
    public GhostStrat(Arena arena) {
        this.arena = arena;
    }
    public abstract Position chasingTarget(Position g_position);
    public Position numbTarget(Position g_position){
        return g_position;
    }
    public Position currentTarget(GhostState state, Position g_position){
        if (state == NUMB) return numbTarget(g_position);
        return chasingTarget(g_position);
    }

}

