package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.model.menu.FinalMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinalMenuStateTest {
    @Test
    void getViewer(){
        FinalMenuState fm = new FinalMenuState(new FinalMenu(true));
        Assertions.assertNotNull(fm.getViewer());
    }
    @Test
    void getController(){
        FinalMenuState fm = new FinalMenuState(new FinalMenu(true));
        Assertions.assertNotNull(fm.getController());
    }
}
