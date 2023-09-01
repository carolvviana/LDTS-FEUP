package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.model.menu.InitialMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuStateTest {
    @Test
    void getViewer(){
        MenuState im = new MenuState(new InitialMenu());
        Assertions.assertNotNull(im.getViewer());
    }
    @Test
    void getController(){
        MenuState im = new MenuState(new InitialMenu());
        Assertions.assertNotNull(im.getController());
    }
}

