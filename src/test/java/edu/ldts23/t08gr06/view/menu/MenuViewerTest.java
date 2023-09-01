package edu.ldts23.t08gr06.view.menu;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class MenuViewerTest {
    private GUI gui;
    private MenuViewer viewer;
    private InitialMenu menu;

    @Test
    void drawElements(){
        gui = Mockito.mock(GUI.class);
        menu = new InitialMenu();
        viewer = new MenuViewer(menu);
        viewer.drawElements(gui);


        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12, 7), "* PACPRINCESS *", "#c8a2c8");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(8, 9), "Run away from the ghosts", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 10), "and get to the door to survive!", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(8, 12), "", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12, 15), "---- MENU ----", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12, 23), "--------------", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 27), "(", "#FFC0CB");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 27), " - The ghosts get numb", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 28), ")", "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 28), " - They kill one of the ghosts", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 29), "}", "#FFFF00");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 29), " - Catch them so that", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(9, 30), "the door shows up", "#FFFFFF");

    }
    @Test
    void drawElementsLoop(){
        gui = Mockito.mock(GUI.class);
        menu = new InitialMenu();
        viewer = new MenuViewer(menu);
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(13 + menu.getNumberEntries())).drawText(any(Position.class), anyString(), anyString());

    }
}
