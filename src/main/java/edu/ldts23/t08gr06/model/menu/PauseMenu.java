package edu.ldts23.t08gr06.model.menu;

import edu.ldts23.t08gr06.states.State;

import java.util.Arrays;

public class PauseMenu extends Menu{
    private State nextState;

    public PauseMenu(State st) {
        setEntries();
        this.nextState = st;
    }
    @Override
    public void setEntries() {
        this.entries = Arrays.asList("Resume", "Go back to Menu", "Quit game");
    }

    public State getNextState() {return nextState;}

}
