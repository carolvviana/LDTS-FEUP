package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import org.junit.jupiter.api.Test;

import static edu.ldts23.t08gr06.model.Direction.DOWN;
import static edu.ldts23.t08gr06.model.Direction.UP;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrincessTest {
    @Test
    void princessConstructor(){
        Princess p = new Princess(1,2,UP);
        assertEquals(1, p.getPosition().getX());
        assertEquals(2, p.getPosition().getY());
        assertEquals(UP, p.getDirection());
        p.setDirection(DOWN);
        assertEquals(DOWN, p.getDirection());
    }
}
