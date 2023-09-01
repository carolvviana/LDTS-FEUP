package edu.ldts23.t08gr06.model;

import java.util.Objects;

public class Direction {
    private int x, y;
    Direction(int x, int y){this.x=x; this.y=y;}
    int getX(){return this.x;}
    int getY(){return this.y;}

    public static Direction NONE = new Direction(0,0);
    public static Direction RIGHT = new Direction(1,0);
    public static Direction LEFT = new Direction(-1,0);
    public static Direction UP = new Direction(0,-1);
    public static Direction DOWN = new Direction(0,1);

    public Direction multiply(int i) {
        return switch (i) {
            case 0 -> Direction.NONE;
            case -1 -> new Direction(-x, -y);
            case 1 -> this;
            default -> new Direction(i * this.x, i * this.y);
        };
    }
    public static Direction from(Position a, Position b) {
        return new Direction(b.getX() - a.getX(), b.getY() - a.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return getX() == direction.getX() && getY() == direction.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
