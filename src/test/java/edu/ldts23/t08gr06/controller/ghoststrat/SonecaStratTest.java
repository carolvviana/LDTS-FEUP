package edu.ldts23.t08gr06.controller.ghoststrat;

import edu.ldts23.t08gr06.controllers.ghoststrat.SonecaStrat;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static edu.ldts23.t08gr06.model.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SonecaStratTest {
    Arena arena;

    @Property
    public void testDivision(@ForAll int number) {
        arena = new Arena(10, 10);
        arena.setPrincess(new Princess(5,5,DOWN));

        SonecaStrat ss = new SonecaStrat(arena);
        assertEquals(arena.getPrincess().getPosition(), ss.chasingTarget(new Position(number,number) ));
    }
}
