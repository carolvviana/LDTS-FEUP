package edu.ldts23.t08gr06.view.menu;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class PauseViewerTest {
    private GUI gui;
    private PauseViewer viewer;
    private PauseMenu menu;

    @Test
    void drawElementsLoop(){
        gui = Mockito.mock(GUI.class);
        menu = new PauseMenu(new MenuState(new InitialMenu()));
        viewer = new PauseViewer(menu);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1 + menu.getNumberEntries())).drawText(any(Position.class), anyString(), anyString());

    }

}
