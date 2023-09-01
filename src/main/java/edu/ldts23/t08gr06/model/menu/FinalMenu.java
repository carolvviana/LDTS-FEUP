package edu.ldts23.t08gr06.model.menu;

import java.util.Arrays;
public class FinalMenu extends Menu{
    private boolean win;

    public FinalMenu(boolean win) {
        setEntries();
        this.win = win;
    }

    @Override
    public void setEntries() {
        this.entries = Arrays.asList("Go back to Menu", "Quit game");
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isWin() {
        return win;
    }
}
