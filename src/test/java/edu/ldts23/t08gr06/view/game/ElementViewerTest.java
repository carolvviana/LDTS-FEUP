package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ElementViewerTest {
    ElementViewer ev;
    @BeforeEach
    void setUp(){
        ev = new ElementViewer<>('F', "ABC");
    }
    @Test
    void getColor(){
        assertEquals("ABC", ev.getColor2());
    }
    @Test
    void getChar(){
        assertEquals('F', ev.getChar2());
    }
    @Test
    void getBackground(){
        Door d1 = Mockito.mock(Door.class);
        Mockito.when(d1.isOpen()).thenReturn(true);
        Door d2 = Mockito.mock(Door.class);
        Mockito.when(d2.isOpen()).thenReturn(false);
        Wall w1 = new Wall(0,0);

        assertTrue(ev.getBackground(w1));
        assertTrue(ev.getBackground(d2));
        assertFalse(ev.getBackground(d1));
    }
}
