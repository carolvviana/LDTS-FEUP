package edu.ldts23.t08gr06.model.game.elements;

import edu.ldts23.t08gr06.model.Direction;

public class Moveable extends Element{
    private Direction direction;
    public Moveable(int x, int y, Direction d){ super(x,y); this.direction=d;}
    @Override
    public Direction getDirection(){return this.direction;}
    @Override
    public void setDirection(Direction d){this.direction = d;}
}
