package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    @Test
    void CoinConstructor(){
        Coin c = new Coin(1,2);
        assertEquals(1, c.getPosition().getX());
        assertEquals(2, c.getPosition().getY());
    }
}
