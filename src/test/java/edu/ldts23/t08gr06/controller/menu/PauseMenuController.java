package edu.ldts23.t08gr06.controller.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.PauseController;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;

public class PauseMenuController {
    Game game;
    Controller controller;
    PauseMenu pm;

    @BeforeEach
    void setUp() {
        Arena arena = new Arena(10, 10);
        arena.setGhosts(Arrays.asList(new Ghost(4, 5, UP, CHASING),new Ghost(5, 6, UP, CHASING), new Ghost(6, 7, UP, CHASING), new Ghost(7, 8, UP, CHASING)));

        game = Mockito.mock(Game.class);
        pm = new PauseMenu(new GameState(arena));
        controller = new PauseController(pm);
    }

    @Test
    void step() throws IOException {
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(2, pm.getCurrentEntry());
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(1, pm.getCurrentEntry());
        controller.step(game, GUI.ACTION.DOWN, 1);
        Assertions.assertEquals(2, pm.getCurrentEntry());
        controller.step(game, GUI.ACTION.UP, 1);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
        controller.step(game, GUI.ACTION.UP, 1);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(GameState.class));

    }
}
