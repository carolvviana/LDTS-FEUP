package edu.ldts23.t08gr06.view.gui;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.view.game.ArenaViewer;
import java.io.IOException;

public abstract class GUI {

    private int height;
    private int width;

    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){
        this.width=width;
    }

    public abstract ACTION getNextAction() throws IOException;
    abstract public void clear();
    abstract public void refresh() throws IOException;
    public abstract void drawElement(Element element, ArenaViewer viewer);
    abstract public void close() throws IOException;
    public abstract void drawFrame();
    public abstract void drawText(Position position, String menu, String s);
    public enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, PAUSE}
}
