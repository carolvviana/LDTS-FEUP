package edu.ldts23.t08gr06.model.menu;

import edu.ldts23.t08gr06.states.FinalMenuState;
import edu.ldts23.t08gr06.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PauseMenuTest {
    PauseMenu pm;
    @BeforeEach
    void setUp(){
        pm = new PauseMenu(new FinalMenuState(new FinalMenu(true)));
    }
    @Test
    void setEntries(){
        pm.setEntries();
        assertEquals("Resume", pm.getEntry(0));
        assertEquals("Go back to Menu", pm.getEntry(1));
        assertEquals("Quit game", pm.getEntry(2));
    }
    @Test
    void getNextState(){
        State s = new FinalMenuState(new FinalMenu(true));
        PauseMenu p = new PauseMenu(s);
        assertEquals(s, p.getNextState());
    }
}
