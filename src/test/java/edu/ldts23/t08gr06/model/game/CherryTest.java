package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CherryTest {
    @Test
    void CherryConstructor(){
        Cherry c = new Cherry(1,2);
        assertEquals(1, c.getPosition().getX());
        assertEquals(2, c.getPosition().getY());
    }
}
