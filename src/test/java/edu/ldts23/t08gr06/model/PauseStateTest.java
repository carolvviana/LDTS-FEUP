package edu.ldts23.t08gr06.model;

import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.PauseController;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.states.PauseState;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.menu.PauseViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class PauseStateTest {
    CustomMap cm;
    Arena a;
    Princess princess;
    Door door;
    List<Wall> walls;
    List<Collectible> collectibles;
    List<Ghost> ghosts;

    @BeforeEach
    void setUp() {
        a = new Arena(10, 10);

        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost(0, 0, UP, CHASING);
        Ghost g2 = new Ghost(1, 1, UP, NUMB);
        Ghost g3 = new Ghost(2, 2, UP, CHASING);
        Ghost g4 = new Ghost(3, 3, UP, NUMB);
        ghosts.add(g1);
        ghosts.add(g2);
        ghosts.add(g3);
        ghosts.add(g4);

        a.setGhosts(ghosts);

        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6, 0);
        Coin c2 = new Coin(6, 1);
        Coin c3 = new Coin(6, 2);
        Flower f1 = new Flower(0, 1);
        Flower f2 = new Flower(0, 2);
        Flower f3 = new Flower(0, 3);
        Cherry ch1 = new Cherry(1, 0);
        Cherry ch2 = new Cherry(2, 0);
        Cherry ch3 = new Cherry(3, 0);
        collectibles.add(c1);
        collectibles.add(c2);
        collectibles.add(c3);
        collectibles.add(f1);
        collectibles.add(f2);
        collectibles.add(f3);
        collectibles.add(ch1);
        collectibles.add(ch2);
        collectibles.add(ch3);
        a.setCollectibles(collectibles);

        walls = new ArrayList<>();
        Wall w1 = new Wall(1, 2);
        Wall w2 = new Wall(1, 3);
        Wall w3 = new Wall(1, 4);
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        a.setWalls(walls);

        door = new Door(2, 3);
        a.setDoor(door);
        princess = new Princess(5, 5, UP);
        a.setPrincess(princess);
    }
    @Test
    void constructor(){
        PauseState ps = new PauseState(new PauseMenu(new GameState(a)));
         Controller<PauseMenu> cont = ps.getController();
         Assertions.assertTrue(cont instanceof PauseController);
        Viewer<PauseMenu> view = ps.getViewer();
        Assertions.assertTrue(view instanceof PauseViewer);
    }
}
