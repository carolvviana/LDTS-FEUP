package edu.ldts23.t08gr06.model;

import edu.ldts23.t08gr06.model.game.arena.Arena;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapBuilderTest {
    @Test
    void createArena() throws IOException {
        CustomMap m = new CustomMap("testmap");
        Arena arena = m.createArena();

        assertEquals(6, arena.getWidth());
        assertEquals(5, arena.getHeight());
        assertEquals(2, arena.getGhosts().size());
        assertEquals(new Position(6,8), arena.getPrincess().getPosition());
        assertEquals(17, arena.getWalls().size());
        assertEquals(4, arena.getCollectibles().size());
        assertEquals(new Position(10,6), arena.getDoor().getPosition());
        assertEquals(new Position(5,5), arena.getWalls().get(0).getPosition());
    }
}


