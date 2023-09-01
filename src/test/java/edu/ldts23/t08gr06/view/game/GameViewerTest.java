package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        List<Wall> walls = new ArrayList<Wall>();
        walls.add(new Wall(1, 2)); walls.add(new Wall(2, 3)); walls.add(new Wall(3, 4));
        arena.setWalls(walls);
        List<Ghost> ghosts = new ArrayList<Ghost>();
        ghosts.add(new Ghost(4, 5, UP, CHASING));ghosts.add(new Ghost(5, 6, UP, CHASING));ghosts.add(new Ghost(6, 7, UP, CHASING));ghosts.add(new Ghost(7, 8, UP, CHASING));
        arena.setGhosts(ghosts);
        arena.setPrincess(new Princess(1,1,UP));
        List<Collectible> collectibles = new ArrayList<Collectible>();
        collectibles.add(new Cherry(2,2));collectibles.add(new Flower(3,3));collectibles.add(new Coin(4,4));
        arena.setCollectibles(collectibles);
        arena.setDoor(new Door(0,0));

        viewer = new GameViewer(arena);
    }


    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawFrame();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawElementsGUI(){
        GameViewer gameViewerSpy = Mockito.spy(viewer);

        gameViewerSpy.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
        Mockito.verify(gameViewerSpy, Mockito.times(3)).drawElements(Mockito.any(GUI.class), Mockito.any(List.class));
        Mockito.verify(gameViewerSpy, Mockito.times(1)).drawElement(Mockito.any(GUI.class), Mockito.any(Princess.class), Mockito.any(ElementViewer.class));
        Mockito.verify(gameViewerSpy, Mockito.times(1)).drawElement(Mockito.any(GUI.class), Mockito.any(Door.class), Mockito.any(ElementViewer.class));
    }
    @Test
    void drawListElementsGUI(){
        GameViewer gameViewerSpy = Mockito.spy(viewer);
        List<Collectible> el = new ArrayList<Collectible>();
        el.add(new Cherry(0,0)); el.add(new Coin(1,1)); el.add(new Flower(2,2));
        gameViewerSpy.drawElements(gui, el);
        var size = el.size();

        Mockito.verify(gameViewerSpy, Mockito.times(size)).drawElement(Mockito.any(GUI.class), Mockito.any(Element.class), Mockito.any(ElementViewer.class));
    }

    @Test
    void getViewer(){
        Flower f1 = new Flower(0,0);
        Cherry ch1 = new Cherry(0,0);
        Coin c1 = new Coin(0,0);
        Princess p1 = new Princess(0,0, UP);
        Ghost g1 = new Ghost(0,0, UP, NUMB);
        Wall d1 = new Wall(0,0);

        assertEquals('(', viewer.getViewer(f1).getChar2());
        assertEquals("#FF0000", viewer.getViewer(ch1).getColor2());
        assertEquals('}', viewer.getViewer(c1).getChar2());
        assertEquals('*', viewer.getViewer(p1).getChar2());
        assertEquals("#FFFFFF", viewer.getViewer(g1).getColor2());
        assertEquals('W', viewer.getViewer(d1).getChar2());
    }

}
