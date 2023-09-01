package edu.ldts23.t08gr06.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitialMenuTest {
    InitialMenu im;
    @BeforeEach
    void setUp(){
        im = new InitialMenu();
    }
    @Test
    void setEntries(){
        im.setEntries();
        assertEquals("Easy", im.getEntry(0));
        assertEquals("Medium", im.getEntry(1));
        assertEquals("Hard", im.getEntry(2));
        assertEquals("Quit", im.getEntry(3));
    }
    @Test
    void nextEntry(){
        im.nextEntry();
        assertEquals(1, im.getCurrentEntry());
        im.nextEntry();
        assertEquals(2, im.getCurrentEntry());
        im.nextEntry();
        assertEquals(3, im.getCurrentEntry());
        im.nextEntry();
        assertEquals(0, im.getCurrentEntry());
    }
    @Test
    void previousEntry(){
        im.previousEntry();
        assertEquals(3, im.getCurrentEntry());
        im.previousEntry();
        assertEquals(2, im.getCurrentEntry());
        im.previousEntry();
        assertEquals(1, im.getCurrentEntry());
        im.previousEntry();
        assertEquals(0, im.getCurrentEntry());
    }
    @Test
    void getNumberEntries(){
        assertEquals(4, im.getNumberEntries());
    }
    @Test
    void isSelected(){
        Assertions.assertTrue(im.isSelected(0));
        assertFalse(im.isSelected(2));
        im.nextEntry();
        assertTrue(im.isSelected(1));
    }
}

