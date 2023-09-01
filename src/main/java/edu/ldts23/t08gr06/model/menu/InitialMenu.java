package edu.ldts23.t08gr06.model.menu;

import java.util.Arrays;

public class InitialMenu extends Menu {

    public InitialMenu() {
            setEntries();
    }

    @Override
    public void setEntries() {
        this.entries = Arrays.asList("Easy","Medium", "Hard", "Quit");
    }

}