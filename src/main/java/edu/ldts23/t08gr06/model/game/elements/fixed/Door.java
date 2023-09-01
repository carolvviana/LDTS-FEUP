package edu.ldts23.t08gr06.model.game.elements.fixed;

import edu.ldts23.t08gr06.model.game.elements.Fixed;

public class Door extends Fixed {
    private boolean open = false;
    public Door(int x, int y){ super(x,y);}
    public boolean isOpen(){return open;}
    public void openDoor(){
        this.open = true;
    }
}
