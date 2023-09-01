package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectibleTest {
    Collectible c1;
    Collectible c2;
    Collectible c3;
    @BeforeEach
    void setUp(){
        c1 = new Flower(1, 2);
        c2 = new Cherry(2, 3);
        c3 = new Coin(3, 4);
    }
    @Test
    void CollectibleConstructor(){
        assertEquals(1, c1.getPosition().getX());
        assertEquals(2, c1.getPosition().getY());
        assertEquals(2, c2.getPosition().getX());
        assertEquals(3, c2.getPosition().getY());
        assertEquals(3, c3.getPosition().getX());
        assertEquals(4, c3.getPosition().getY());
    }
    @Test
    void getCounter(){
        assertEquals(10, c1.getCounter());
        assertEquals(10, c2.getCounter());
        assertEquals(10, c3.getCounter());
    }
    @Test
    void decreaseCounter(){
        c1.decreaseCounter();c2.decreaseCounter();c3.decreaseCounter();
        assertEquals(9, c1.getCounter());
        assertEquals(9, c2.getCounter());
        assertEquals(9, c3.getCounter());
    }
}
