package edu.ldts23.t08gr06.model;

import org.junit.jupiter.api.Test;


import static edu.ldts23.t08gr06.model.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void getCoordinates(){
        Direction d = new Direction(1,1);
        assertEquals(1, d.getX());
        assertEquals(1, d.getY());
    }
    @Test
    void multiply() {
        int i1 = 2;
        int i2 = -1;
        int i3 = 1;
        int i4 = 0;
        Direction d = new Direction(1,1);
        assertEquals(new Direction(2,2), d.multiply(i1));
        assertEquals(new Direction(-1,-1), d.multiply(i2));
        assertEquals(new Direction(1,1), d.multiply(i3));
        assertEquals(new Direction(0,0), d.multiply(i4));
    }
    @Test
    void fromTest(){
        Position a = new Position(1,1);
        Position b = new Position(2,2);
        assertEquals(new Direction(1,1), Direction.from(a,b));
    }
    @Test
    void testDefaults(){
        assertEquals(new Direction(0, 0), NONE);
        assertEquals(new Direction(1, 0), RIGHT);
        assertEquals(new Direction(-1, 0), LEFT);
        assertEquals(new Direction(0, -1), UP);
        assertEquals(new Direction(0, 1), DOWN);
    }

}
