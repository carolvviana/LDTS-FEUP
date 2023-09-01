package edu.ldts23.t08gr06.controller.game;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.gamecontroller.CollectiblesController;
import edu.ldts23.t08gr06.controllers.gamecontroller.GameController;
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
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.states.PauseState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class GameControllerTest {
    Arena arena;
    Princess princess;
    Door door;
    List<Wall> walls;
    List<Collectible> collectibles;
    List<Ghost> ghosts;
    Game game;
    Game game2;
    Game game3;
    @BeforeEach
    void setUp(){
        arena = new Arena(10,10);

        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost(0,0, UP, CHASING);
        Ghost g2 = new Ghost(1,1, UP, NUMB);
        Ghost g3 = new Ghost(2,2, UP, CHASING);
        Ghost g4 = new Ghost(3,3, UP, NUMB);
        ghosts.add(g1);
        ghosts.add(g2);
        ghosts.add(g3);
        ghosts.add(g4);

        arena.setGhosts(ghosts);

        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6,0);
        Flower f1 = new Flower(0,1);
        Cherry ch1 = new Cherry(1,0);
        collectibles.add(c1);
        collectibles.add(f1);
        collectibles.add(ch1);
        arena.setCollectibles(collectibles);

        walls = new ArrayList<>();
        Wall w1 = new Wall(1,2); Wall w2 = new Wall(1,3); Wall w3 = new Wall(1,4);
        walls.add(w1); walls.add(w2); walls.add(w3);
        arena.setWalls(walls);

        door = new Door(2,3);
        arena.setDoor(door);
        princess = new Princess(5,5, UP);
        arena.setPrincess(princess);
    }

    @Test
    void stepController() throws IOException {
        game = Mockito.mock(Game.class);
        GameController controller = new GameController(arena);
        controller.step(game, GUI.ACTION.QUIT, 1100);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));

        game2 = Mockito.mock(Game.class);
        controller.step(game2, GUI.ACTION.PAUSE, 1100);
        Mockito.verify(game2, Mockito.times(1)).setState(Mockito.any(PauseState.class));

        game3 = Mockito.mock(Game.class);
        CollectiblesController colContMock = Mockito.mock(CollectiblesController.class);
        PrincessController priContMock = Mockito.mock(PrincessController.class);
        GhostController ghostContMock = Mockito.mock(GhostController.class);
        GameController controller2 = new GameController(arena, ghostContMock, priContMock, colContMock);
        controller2.step(game3, GUI.ACTION.LEFT, 1100);
        Mockito.verify(ghostContMock, Mockito.times(1)).step(game3, 1100);
        Mockito.verify(priContMock, Mockito.times(1)).step(game3,GUI.ACTION.LEFT, 1100);
        Mockito.verify(colContMock, Mockito.times(1)).step();
        Mockito.verify(colContMock, Mockito.times(1)).stepFlower(1100);

    }
}
