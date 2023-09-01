package edu.ldts23.t08gr06.model.menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FinalMenuTest {
    FinalMenu fm;

    @BeforeEach
    void setUp(){
        fm = new FinalMenu(false);
    }
    @Test
    void setEntries(){
        fm.setEntries();
        assertEquals("Go back to Menu", fm.getEntry(0));
        assertEquals("Quit game", fm.getEntry(1));
    }
    @Test
    void isWin(){
        assertFalse(fm.isWin());
        fm.setWin(true);
        Assertions.assertTrue(fm.isWin());
    }
}
