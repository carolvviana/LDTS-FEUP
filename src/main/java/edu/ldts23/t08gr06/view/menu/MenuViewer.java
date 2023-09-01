package edu.ldts23.t08gr06.view.menu;


import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.gui.GUI;

public class MenuViewer extends Viewer<InitialMenu> {
    public MenuViewer(InitialMenu initialMenu) {
        super(initialMenu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 7), "* PACPRINCESS *", "#c8a2c8");
        gui.drawText(new Position(8, 9), "Run away from the ghosts", "#FFFFFF");
        gui.drawText(new Position(5, 10), "and get to the door to survive!", "#FFFFFF");
        gui.drawText(new Position(8, 12), "", "#FFFFFF");
        gui.drawText(new Position(12, 15), "---- MENU ----", "#FFFFFF");
        gui.drawText(new Position(12, 23), "--------------", "#FFFFFF");
        gui.drawText(new Position(5, 27), "(", "#FFC0CB");
        gui.drawText(new Position(6, 27), " - The ghosts get numb", "#FFFFFF");
        gui.drawText(new Position(5, 28), ")", "#FF0000");
        gui.drawText(new Position(6, 28), " - They kill one of the ghosts", "#FFFFFF");
        gui.drawText(new Position(5, 29), "}", "#FFFF00");
        gui.drawText(new Position(6, 29), " - Catch them so that", "#FFFFFF");
        gui.drawText(new Position(9, 30), "the door shows up", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(16, 18 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

    }


}
