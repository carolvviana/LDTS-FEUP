package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlowerTest {
    @Test
    void FlowerConstructor(){
        Flower f = new Flower(1,2);
        assertEquals(1, f.getPosition().getX());
        assertEquals(2, f.getPosition().getY());
    }
}
