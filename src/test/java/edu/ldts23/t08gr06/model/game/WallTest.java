package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    void wallConstructor(){
        Wall w = new Wall(1,1);
        assertEquals(1, w.getPosition().getX());
        assertEquals(1, w.getPosition().getY());
    }
}
