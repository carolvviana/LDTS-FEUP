package edu.ldts23.t08gr06.model.game;

import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {
    Door door;
    @BeforeEach
    void setUp(){
        door = new Door(1,1);
    }
    @Test
    void DoorConstructor(){
        assertEquals(1, door.getPosition().getX());
        assertEquals(1, door.getPosition().getY());
    }
    @Test
    void isOpen(){
        assertFalse(door.isOpen());
        door.openDoor();
        assertTrue(door.isOpen());
    }
}
