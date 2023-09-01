package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class GameStateTest {
    Arena a;
    ArrayList<Ghost> ghosts;
    @BeforeEach
    void setUp(){
        a = new Arena(10,10);
        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost(0,0, UP, CHASING);
        Ghost g2 = new Ghost(1,1, UP, NUMB);
        Ghost g3 = new Ghost(2,2, UP, CHASING);
        Ghost g4 = new Ghost(3,3, UP, NUMB);
        ghosts.add(g1);
        ghosts.add(g2);
        ghosts.add(g3);
        ghosts.add(g4);

        a.setGhosts(ghosts);
    }

    @Test
    void getViewer(){
        GameState gm = new GameState(a);
        Assertions.assertNotNull(gm.getViewer());
    }
    @Test
    void getController(){
        GameState gm = new GameState(a);
        Assertions.assertNotNull(gm.getController());
    }

}
