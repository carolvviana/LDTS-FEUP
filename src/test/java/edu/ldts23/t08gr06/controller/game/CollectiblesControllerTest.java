package edu.ldts23.t08gr06.controller.game;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.gamecontroller.CollectiblesController;
import edu.ldts23.t08gr06.controllers.gamecontroller.GhostController;
import edu.ldts23.t08gr06.controllers.gamecontroller.PrincessController;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectiblesControllerTest {
    Arena a;
    Princess princess;
    Door door;
    List<Wall> walls;
    List<Collectible> collectibles;
    List<Ghost> ghosts;
    Game game;
    PrincessController princessController;
    GhostController ghostController;
    CollectiblesController controller;


    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        a = new Arena(10, 10);


        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost(5, 4, UP, CHASING);
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
        Flower f1 = new Flower(0, 1);
        Cherry ch1 = new Cherry(1, 0);
        collectibles.add(c1);
        collectibles.add(f1);
        collectibles.add(ch1);
        a.setCollectibles(collectibles);

        walls = new ArrayList<>();
        Wall w1 = new Wall(1, 2);
        walls.add(w1);
        a.setWalls(walls);

        door = new Door(2, 3);
        a.setDoor(door);
        ghostController = new GhostController(a);
        princessController = new PrincessController(a);
        controller = new CollectiblesController(a);
        game.setState(new GameState(a));
    }
    @Test
    void stepCherry() throws IOException {
        princess = new Princess(1, 0, UP);
        a.setPrincess(princess);
        controller.step();

        assertEquals(3, a.getGhosts().size());
        assertEquals(2, a.getCollectibles().size());
    }
    @Test
    void stepCoin() throws IOException {
        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6, 0);
        Flower f1 = new Flower(0, 1);
        Cherry ch1 = new Cherry(1, 0);
        collectibles.add(c1);
        collectibles.add(f1);
        collectibles.add(ch1);
        a.setCollectibles(collectibles);
        princess = new Princess(6, 0, UP);
        a.setPrincess(princess);
        controller.step();

        assertEquals(2, a.getCollectibles().size());
        assertEquals(f1, a.getCollectibles().get(0));
    }
    @Test
    void stepFlower() throws IOException {
        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6, 0);
        Flower f1 = new Flower(0, 1);
        Cherry ch1 = new Cherry(1, 0);
        collectibles.add(c1);
        collectibles.add(f1);
        collectibles.add(ch1);
        a.setCollectibles(collectibles);
        princess = new Princess(0, 1, UP);
        a.setPrincess(princess);

        assertEquals(a.getCollectibles().size(), 3);

        controller.stepFlower(1100);

        assertEquals(a.getCollectibles().size(), 2);
        assertEquals(f1.getCounter(), 9);
        assertEquals(controller.getTimeSinceState(), 1100);
    }


}
