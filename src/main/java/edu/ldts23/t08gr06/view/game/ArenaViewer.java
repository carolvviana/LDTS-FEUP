package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.view.gui.GUI;

public abstract class ArenaViewer {
    char letter;
    public ArenaViewer(char letter){
        this.letter = letter;
    }
    void draw(Element element, GUI gui, ArenaViewer viewer){
        gui.drawElement(element, viewer);
    }
    public abstract String getColor2();
    public abstract char getChar2();
    public abstract boolean getBackground(Element e);
}
