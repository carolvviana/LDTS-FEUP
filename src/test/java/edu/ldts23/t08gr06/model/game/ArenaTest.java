package edu.ldts23.t08gr06.model.game;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.*;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    Arena a;
    Princess princess;
    Door door;
    List<Wall> walls;
    List<Collectible> collectibles;
    List<Ghost> ghosts;
    @BeforeEach
    void setUp() {
        a = new Arena(10,10);

        ghosts = new ArrayList<>();
        Ghost g1 = new Ghost(0,0, UP, CHASING);
        Ghost g2 = new Ghost(1,1, UP, NUMB);
        Ghost g3 = new Ghost(2,2, UP, CHASING);
        Ghost g4 = new Ghost(3,3, UP, NUMB);
        ghosts.add(g1);
        ghosts.add(g2);
        ghosts.add(g3);
        ghosts.add(g4);

        a.setGhosts(ghosts);

        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6,0); Coin c2 = new Coin(6,1); Coin c3 = new Coin(6,2);
        Flower f1 = new Flower(0,1); Flower f2 = new Flower(0,2); Flower f3 = new Flower(0,3);
        Cherry ch1 = new Cherry(1,0); Cherry ch2 = new Cherry(2,0); Cherry ch3 = new Cherry(3,0);
        collectibles.add(c1); collectibles.add(c2); collectibles.add(c3);
        collectibles.add(f1); collectibles.add(f2); collectibles.add(f3);
        collectibles.add(ch1); collectibles.add(ch2); collectibles.add(ch3);
        a.setCollectibles(collectibles);

        walls = new ArrayList<>();
        Wall w1 = new Wall(1,2); Wall w2 = new Wall(1,3); Wall w3 = new Wall(1,4);
        walls.add(w1); walls.add(w2); walls.add(w3);
        a.setWalls(walls);

        door = new Door(2,3);
        a.setDoor(door);
        princess = new Princess(5,5, UP);
        a.setPrincess(princess);

    }

    @Test
    void getPrincess() {
        assertEquals(princess, a.getPrincess());
    }

    @Test
    void getDoor() {
        Assertions.assertEquals(door,a.getDoor());
    }

    @Test
    void getWalls() {
        Assertions.assertEquals(walls,a.getWalls());
    }

    @Test
    void getCollectibles() {
        Assertions.assertEquals(collectibles,a.getCollectibles());
    }

    @Test
    void getGhosts() {
        Assertions.assertEquals(ghosts,a.getGhosts());
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(10,a.getWidth());
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(10,a.getHeight());
    }

    @Test
    void CoinsLeft(){
        assertEquals(3, a.coinsLeft());
    }

    @Test
    void isEnemy(){
        assertTrue(a.isEnemy(new Position(0,0)));
        assertFalse(a.isEnemy(new Position(1,1)));
        assertFalse(a.isEnemy(new Position(1,0)));
    }
    @Test
    void isPrincess(){
        assertTrue(a.isPrincess(new Position(5,5)));
        assertFalse(a.isPrincess(new Position(1,0)));
    }
    @Test
    void isFlower(){
        assertTrue(a.isFlower(new Position(0,1)));
        assertFalse(a.isFlower(new Position(1,0)));
        assertFalse(a.isFlower(new Position(6,0)));
    }
    @Test
    void isCherry(){
        assertTrue(a.isCherry(new Position(1,0)));
        assertFalse(a.isCherry(new Position(0,2)));
        assertFalse(a.isCherry(new Position(4,4)));
    }
    @Test
    void isCoin(){
        assertTrue(a.isCoin(new Position(6,0)));
        assertFalse(a.isCoin(new Position(1,0)));
        assertFalse(a.isCoin(new Position(0,1)));
    }
    @Test
    void removeGhost(){
        a.removeGhost();
        assertEquals(3, ghosts.size());
        a.removeGhost();
        assertEquals(2, ghosts.size());
        a.removeGhost();
        assertEquals(1, ghosts.size());
        a.removeGhost();
        assertEquals(0, ghosts.size());
    }
    @Test
    void isNotWall(){
        assertTrue(a.isNotWall(new Position(0,0)));
        assertFalse(a.isNotWall(new Position(1,2)));
    }
    @Test
    void isEmpty(){
        assertTrue(a.isEmpty(new Position(3,2)));
        assertFalse(a.isEmpty(new Position(1,2)));
        assertFalse(a.isEmpty(new Position(0,0)));
        assertFalse(a.isEmpty(new Position(2,3)));
    }
    @Test
    void isDoor(){
        assertTrue(a.isDoor(new Position(2,3)));
        assertFalse(a.isDoor(new Position(1,2)));
    }
    @Test
    void removeCollectible(){
        a.removeCollectible(new Position(6,0));
        assertEquals(8, collectibles.size());
        a.removeCollectible(new Position(0,0));
        assertEquals(8, collectibles.size());
        a.removeCollectible(new Position(1,3));
        assertEquals(8, collectibles.size());
    }
    @Test
    void getCollectibleAt(){
        Coin c1 = (Coin)collectibles.get(0);
        Flower f1 = (Flower) collectibles.get(3);
        Cherry ch1 = (Cherry) collectibles.get(6);

        assertEquals(c1, a.getCollectibleAt(new Position(6,0)));
        assertEquals(f1, a.getCollectibleAt(new Position(0,1)));
        assertEquals(ch1, a.getCollectibleAt(new Position(1,0)));
    }
    @Test
    void numbGhosts(){
        a.setPrincess(new Princess(0,1, UP));
        a.numbGhosts();
        assertEquals(NUMB, a.getGhosts().get(0).getState());
        assertEquals(8, a.getCollectibles().size());
    }
}



















