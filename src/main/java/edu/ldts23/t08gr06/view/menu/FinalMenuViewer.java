package edu.ldts23.t08gr06.view.menu;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.gui.GUI;

public class FinalMenuViewer extends Viewer<FinalMenu> {

    public FinalMenuViewer(FinalMenu finalMenu) { super(finalMenu);}

    @Override
    public void drawElements(GUI gui){

        if(getModel().isWin()){
            gui.drawText(new Position(13, 8), "Congrats!", "#FFFFFF");

            gui.drawText(new Position(12, 9), "You won! :D", "#FFFFFF");
        }
        else {
            gui.drawText(new Position(9, 9), "AAAAAH! Game Ooooover :O", "#FFFFFF");
        }

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(12, 12 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

