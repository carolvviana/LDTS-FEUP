package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostTest {
    Ghost g1;
    Ghost g2;
    @BeforeEach
    void setUp(){
        g1 = new Ghost(1,1,UP, CHASING);
        g2 = new Ghost(2,2, UP, NUMB);
    }
    @Test
    void ghostContructor(){
        assertEquals(1,g1.getPosition().getX());
        assertEquals(1,g1.getPosition().getY());
        assertEquals(2,g2.getPosition().getX());
        assertEquals(2,g2.getPosition().getY());
    }
    @Test
    void ghostState(){
        assertEquals(CHASING,g1.getState());
        assertEquals(NUMB, g2.getState());
    }
    @Test
    void setState(){
        g1.setState(NUMB);
        assertEquals(NUMB,g1.getState());
        g2.setState(CHASING);
        assertEquals(CHASING, g2.getState());
    }
    @Test
    void setgetStrat(){
        AtchimStrat a = new AtchimStrat(new Arena(10,10));
        MestreStrat m = new MestreStrat(new Arena(10,10));
        g1.setStrat(a);
        g2.setStrat(m);
        assertEquals(a, g1.getStrat());
        assertEquals(m, g2.getStrat());
    }

}
