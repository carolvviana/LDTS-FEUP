package edu.ldts23.t08gr06.controller.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.FinalMenuController;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class FinalMenuControllerTest {
    Game game;
    Controller controller;
    FinalMenu fm;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        fm = new FinalMenu(true);
        controller = new FinalMenuController(fm);
    }

    @Test
    void step() throws IOException {
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(1, fm.getCurrentEntry());
        controller.step(game, GUI.ACTION.UP, 1);
        Assertions.assertEquals(0, fm.getCurrentEntry());
        controller.step(game, GUI.ACTION.DOWN, 1);
        Assertions.assertEquals(1, fm.getCurrentEntry());
        controller.step(game, GUI.ACTION.SELECT, 1);
        controller.step(game, GUI.ACTION.UP, 1);
        controller.step(game, GUI.ACTION.SELECT, 1);
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));


    }
}
