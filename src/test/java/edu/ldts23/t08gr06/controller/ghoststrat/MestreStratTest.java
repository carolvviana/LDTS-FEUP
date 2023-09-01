package edu.ldts23.t08gr06.controller.ghoststrat;

import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static edu.ldts23.t08gr06.model.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MestreStratTest {
    Arena arena;

    @BeforeEach
    void setUp(){
        arena = new Arena(10, 10);
    }
    @Test
    void chasingTarget(){
        arena.setPrincess(new Princess(5,5,UP));
        MestreStrat ms = new MestreStrat(arena);
        assertEquals(new Position(5,5), ms.chasingTarget(new Position(13,5)));
        assertEquals(new Position(5,5), ms.chasingTarget(new Position(5,15)));
        assertEquals(new Position(0,9), ms.chasingTarget(new Position(0,1)));
    }
}
