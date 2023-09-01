package edu.ldts23.t08gr06.model.game.elements;

import edu.ldts23.t08gr06.model.Direction;
import edu.ldts23.t08gr06.model.Position;

public abstract class Element{
    private Position position;
    private Direction direction;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public Direction getDirection() {return this.direction;}

    public void setDirection(Direction direction) { this.direction = direction;}
    }


