package edu.ldts23.t08gr06.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static edu.ldts23.t08gr06.model.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void setX() {
        int x = 3;
        Position p = new Position(0,0);
        p.setX(x);
        assertEquals(3,p.getX());
    }
    @Test
    void setY() {
        int y = 3;
        Position p = new Position(0,0);
        p.setY(y);
        assertEquals(3,p.getY());
    }
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }
    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }
    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }
    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Test
    void addDirection(){
        Position p = new Position(1,1);
        Direction d = new Direction(1,1);
        assertEquals(2, p.addDirection(d).getX());
        assertEquals(2, p.addDirection(d).getY());
    }
    @Test
    void distance(){
        Position p1 = new Position(1,0);
        Position p2 = new Position(2,0);
        assertEquals(1, p1.distance(p2));
    }
    @Test
    void nextPositionWithDirection(){
        Position p = new Position(1,1);
        Direction d1 = UP;
        Direction d2 = DOWN;
        Direction d3 = RIGHT;
        Direction d4 = LEFT;
        assertEquals(1, p.nextPositionWithDirection(d1).getX());
        assertEquals(0, p.nextPositionWithDirection(d1).getY());
        assertEquals(1, p.nextPositionWithDirection(d2).getX());
        assertEquals(2, p.nextPositionWithDirection(d2).getY());
        assertEquals(2, p.nextPositionWithDirection(d3).getX());
        assertEquals(1, p.nextPositionWithDirection(d3).getY());
        assertEquals(0, p.nextPositionWithDirection(d4).getX());
        assertEquals(1, p.nextPositionWithDirection(d4).getY());
    }
}
