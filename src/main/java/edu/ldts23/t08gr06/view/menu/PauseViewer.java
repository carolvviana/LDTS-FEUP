package edu.ldts23.t08gr06.view.menu;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.gui.GUI;

public class PauseViewer extends Viewer<PauseMenu> {

    public PauseViewer(PauseMenu pauseMenu) { super(pauseMenu);}

    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5, 5), "Game Paused", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
        gui.drawText(
                new Position(5, 7 + i),
                getModel().getEntry(i),
                getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
