package edu.ldts23.t08gr06.view.menu;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class FinalMenuTest {
    private GUI gui;
    private FinalMenuViewer viewer;
    private FinalMenu menu;

    @Test
    void drawElements(){
        gui = Mockito.mock(GUI.class);
        menu = new FinalMenu(true);
        viewer = new FinalMenuViewer(menu);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(2+ menu.getNumberEntries())).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
    @Test
    void drawElementsLoss(){
        gui = Mockito.mock(GUI.class);
        menu = new FinalMenu(false);
        viewer = new FinalMenuViewer(menu);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1+ menu.getNumberEntries())).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
