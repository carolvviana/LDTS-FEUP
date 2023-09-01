package edu.ldts23.t08gr06.controller.ghoststrat;

import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
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

public class AtchimStratTest {
    Arena arena;
    @BeforeEach
    void setUp(){
        arena = new Arena(10, 10);
    }
    @Test
    void chasingTarget(){
        arena.setPrincess(new Princess(5,5,UP));
        AtchimStrat as = new AtchimStrat(arena);
        assertEquals(new Position(1,1), as.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,DOWN));
        assertEquals(new Position(5,9), as.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,LEFT));
        assertEquals(new Position(1,5), as.chasingTarget(new Position(0,1)));
        arena.setPrincess(new Princess(5,5,RIGHT));
        assertEquals(new Position(9,5), as.chasingTarget(new Position(0,1)));
    }
    @Property
    public void testDivision(@ForAll @Positive int number) {
        arena = new Arena(10, 10);
        arena.setPrincess(new Princess(5,5,DOWN));

        AtchimStrat as = new AtchimStrat(arena);
        assertEquals(arena.getPrincess().getPosition().addDirection(arena.getPrincess().getDirection().multiply(4)), as.chasingTarget(new Position(number,number) ));
    }
}
