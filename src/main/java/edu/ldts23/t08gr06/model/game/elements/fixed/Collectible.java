package edu.ldts23.t08gr06.model.game.elements.fixed;

import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.Fixed;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;

public abstract class Collectible extends Fixed {
    int counter = 10;
    public Collectible(int x, int y){ super(x,y);}

    public int getCounter(){return counter;}
    public void decreaseCounter(){counter--;}

}
