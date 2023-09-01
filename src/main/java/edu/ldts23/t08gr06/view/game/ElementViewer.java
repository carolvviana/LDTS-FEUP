package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;

public class ElementViewer<T extends Element> extends ArenaViewer{

    private String color;

    public ElementViewer(char letter, String color){
        super(letter);
        this.color = color;
    }

    @Override
    public String getColor2(){return this.color;}

    @Override
    public char getChar2(){return this.letter;}

    @Override
    public boolean getBackground(Element e){
        if (e instanceof Wall) return true;
        if (e instanceof Door) {
            return !((Door) e).isOpen();
        }
        return false;
    }

}
