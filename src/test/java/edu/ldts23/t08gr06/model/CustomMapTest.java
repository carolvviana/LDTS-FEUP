package edu.ldts23.t08gr06.model;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomMapTest {
    private CustomMap customMap;

    @BeforeEach
    void setUp() throws IOException {
        customMap = new CustomMap("testmap");
    }

    @Test
    void getWidth() {
        assertEquals(6,customMap.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(5,customMap.getHeight());
    }

    @Test
    void createGhosts() {
        List<Ghost> l = customMap.createGhosts();
        assertEquals(2, l.size());

        Position p = new Position(9,8);
        assertEquals(p, l.get(1).getPosition());
    }

    @Test
    void createWalls() {
        List<Wall> l = customMap.createWalls();
        assertEquals(17, l.size());
        Position p1 = new Position(5,5);
        assertEquals(p1, l.get(0).getPosition());
    }

    @Test
    void createCollectibles() {
        List<Collectible> l = customMap.createCollectibles();
        assertEquals(4, l.size());
        assertTrue(l.get(0) instanceof Cherry);
        Position p = new Position(7,7);
        assertEquals(p, l.get(2).getPosition());
    }

    @Test
    void createPrincess() {
        Princess pri = customMap.createPrincess();
        Position p = new Position(6,8);
        assertEquals(p, pri.getPosition());
    }

    @Test
    void createDoor() {
        Door d = customMap.createDoor();
        Position p = new Position(10,6);
        assertEquals(p, d.getPosition());
    }

    @Test
    void createArena() {
        Arena a = customMap.createArena();
        assertEquals(6, a.getWidth());
        assertEquals(5,a.getHeight());
    }
}
