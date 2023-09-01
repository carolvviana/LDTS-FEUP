package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArenaViewerTest {
    Element e = new Flower(0,0);
    GUI gui;
    ArenaViewer viewer = new ElementViewer<>('f', "ABC");

    @Test
    void draw(){
        gui = Mockito.mock(GUI.class);
        viewer.draw(e, gui, viewer);
        Mockito.verify(gui, Mockito.times(1)).drawElement(e, viewer);
    }
}
