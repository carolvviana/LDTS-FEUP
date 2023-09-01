package edu.ldts23.t08gr06.model;

import java.util.Objects;

import static edu.ldts23.t08gr06.model.Direction.*;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }
    public Position getLeft() {
        return new Position(x - 1, y);
    }
    public Position getRight() {
        return new Position(x + 1, y);
    }
    public Position getUp() {
        return new Position(x, y - 1);
    }
    public Position getDown() {
        return new Position(x, y + 1);
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public Position addDirection(Direction v) {
        return new Position(this.x + v.getX(), this.y + v.getY());
    }

    public double distance(Position p) {
        return Math.sqrt((this.x - p.getX())*(this.x - p.getX()) + (this.y - p.getY())*(this.y - p.getY()));
    }

    @Override
    public String toString(){
        return "Princess position: " + this.x + ',' + this.y + " | ";
    }

    public Position nextPositionWithDirection(Direction dir) {
        if (UP.equals(dir)) {
            return new Position(this.getUp());
        } else if (DOWN.equals(dir)) {
            return new Position(this.getDown());
        } else if (RIGHT.equals(dir)) {
            return new Position(this.getRight());
        } else if (LEFT.equals(dir)) {
            return new Position(this.getLeft());
        }
        return null;
    }
}
