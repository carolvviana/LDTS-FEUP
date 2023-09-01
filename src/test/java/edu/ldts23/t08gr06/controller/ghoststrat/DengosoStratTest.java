package edu.ldts23.t08gr06.controller.ghoststrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.DengosoStrat;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static edu.ldts23.t08gr06.model.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DengosoStratTest {
    Arena arena;

    @BeforeEach
    void setUp(){
        arena = new Arena(10, 10);

    }
    @Test
    void chasingTarget(){
        arena.setPrincess(new Princess(5,5,UP));
        DengosoStrat ds = new DengosoStrat(arena);
        assertEquals(new Position(3,3), ds.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,DOWN));
        assertEquals(new Position(5,7), ds.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,LEFT));
        assertEquals(new Position(3,5), ds.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,RIGHT));
        assertEquals(new Position(7,5), ds.chasingTarget(new Position(0,1)));
    }
    @Property
    public void testDivision(@ForAll @Positive int number) {
        arena = new Arena(10, 10);
        arena.setPrincess(new Princess(5,5,DOWN));

        DengosoStrat ds = new DengosoStrat(arena);
        assertEquals(arena.getPrincess().getPosition().addDirection(arena.getPrincess().getDirection().multiply(2)), ds.chasingTarget(new Position(number,number) ));
    }
}
