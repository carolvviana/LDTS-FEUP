package edu.ldts23.t08gr06.controller.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.MenuController;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class MenuControllerTest {
    Game game;
    Controller controller;
    InitialMenu im;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        im = new InitialMenu();
        controller = new MenuController(im);
    }

    @Test
    void step() throws IOException {
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(3, im.getCurrentEntry());
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(2, im.getCurrentEntry());
        controller.step(game, GUI.ACTION.DOWN, 1);
        Assertions.assertEquals(3, im.getCurrentEntry());
        controller.step(game, GUI.ACTION.SELECT, 1);
        Assertions.assertNull(game.getState());
        controller.step(game, GUI.ACTION.UP, 1);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(GameState.class));

    }
}
