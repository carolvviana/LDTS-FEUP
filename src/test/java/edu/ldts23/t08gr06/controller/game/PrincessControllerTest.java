package edu.ldts23.t08gr06.controller.game;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.gamecontroller.GhostController;
import edu.ldts23.t08gr06.controllers.gamecontroller.PrincessController;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.states.FinalMenuState;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.*;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrincessControllerTest {

    Arena a;
    Princess princess;
    Door door;
    List<Wall> walls;
    List<Collectible> collectibles;
    List<Ghost> ghosts;
    Game game;
    PrincessController controller;
    GhostController ghostController;

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
        princess = new Princess(5, 5, UP);
        a.setPrincess(princess);
        ghostController = new GhostController(a);
        controller = new PrincessController(a);
        game.setState(new GameState(a));
    }

    @Test
    void moveLeft() {
        controller.movePrincessLeft(game);
        assertEquals(new Position(4, 5), princess.getPosition());
    }

    @Test
    void moveLeftWall() {
        a.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.movePrincessLeft(game);
        assertEquals(new Position(5, 5), princess.getPosition());
    }
    @Test
    void moveUP() {
        controller.movePrincessUp(game);
        assertEquals(new Position(5, 4), princess.getPosition());
    }
    @Test
    void moveUPGhostChasing() {
        controller.movePrincessUp(game);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(FinalMenuState.class));

    }
    @Test
    void moveRight() {
        controller.movePrincessRight(game);
        assertEquals(new Position(6, 5), princess.getPosition());
    }
    @Test
    void moveRightDoorClosed() {
        door = new Door(6, 5);
        a.setDoor(door);
        controller.movePrincessRight(game);
        assertEquals(new Position(5, 5), princess.getPosition());
    }
    @Test
    void moveDown() {
        controller.movePrincessDown(game);
        assertEquals(new Position(5, 6), princess.getPosition());
    }

    @Test
    void moveDownDoorOpen() {
        door = new Door(5, 6);
        door.openDoor();
        a.setDoor(door);
        controller.movePrincessDown(game);
        assertEquals(new Position(5, 6), princess.getPosition());
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(FinalMenuState.class));


    }

    @Test
    void stepUp() {
        princess = new Princess(8, 8, UP);
        a.setPrincess(princess);
        controller.step(game, GUI.ACTION.UP, 10);
        assertEquals(new Position(8, 7), princess.getPosition());
        assertEquals(UP, princess.getDirection());
    }
    @Test
    void stepDowm() {
        princess = new Princess(8, 8, UP);
        a.setPrincess(princess);
        controller.step(game, GUI.ACTION.DOWN, 10);
        assertEquals(new Position(8, 9), princess.getPosition());
        assertEquals(DOWN, princess.getDirection());
    }
    @Test
    void stepRight() {
        princess = new Princess(8, 8, UP);
        a.setPrincess(princess);
        controller.step(game, GUI.ACTION.RIGHT, 10);
        assertEquals(new Position(9, 8), princess.getPosition());
        assertEquals(RIGHT, princess.getDirection());
    }
    @Test
    void stepLeft() {
        princess = new Princess(8, 8, UP);
        a.setPrincess(princess);
        controller.step(game, GUI.ACTION.LEFT, 10);
        assertEquals(new Position(7, 8), princess.getPosition());
        assertEquals(LEFT, princess.getDirection());
    }

}
