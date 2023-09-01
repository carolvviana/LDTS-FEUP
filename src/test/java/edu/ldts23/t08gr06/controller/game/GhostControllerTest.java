package edu.ldts23.t08gr06.controller.game;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.gamecontroller.GhostController;
import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.DengosoStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.SonecaStrat;
import edu.ldts23.t08gr06.model.Direction;
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
import edu.ldts23.t08gr06.states.FinalMenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.*;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class GhostControllerTest {
    Game game;
    Arena a;
    Princess princess;
    Door door;
    java.util.List<Wall> walls;
    java.util.List<Collectible> collectibles;
    List<Ghost> ghosts;
    GhostController controller;
    Ghost g1;
    Ghost g2;
    Ghost g3;
    Ghost g4;
    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        a = new Arena(10,10);

        ghosts = new ArrayList<>();
        g1 = new Ghost(5,5, UP, CHASING);
        g2 = new Ghost(1,1, UP, NUMB);
        g3 = new Ghost(2,2, UP, CHASING);
        g4 = new Ghost(3,3, UP, NUMB);
        ghosts.add(g1);
        ghosts.add(g2);
        ghosts.add(g3);
        ghosts.add(g4);

        a.setGhosts(ghosts);

        collectibles = new ArrayList<>();
        Coin c1 = new Coin(6,0);
        Flower f1 = new Flower(0,1);
        Cherry ch1 = new Cherry(1,0);
        collectibles.add(c1);
        collectibles.add(f1);
        collectibles.add(ch1);
        a.setCollectibles(collectibles);

        walls = new ArrayList<>();
        Wall w1 = new Wall(1,2); Wall w2 = new Wall(1,3); Wall w3 = new Wall(1,4);
        walls.add(w1); walls.add(w2); walls.add(w3);
        a.setWalls(walls);

        door = new Door(2,3);
        a.setDoor(door);
        princess = new Princess(4,5, UP);
        a.setPrincess(princess);
        controller = new GhostController(a);
    }

    @Test
    void step() throws IOException {
        controller.setGhostStrats();
        controller.step(game, 1100);

        Assertions.assertTrue(ghosts.get(1).getDirection().equals(Direction.RIGHT));
        Assertions.assertTrue(ghosts.get(2).getDirection().equals(Direction.DOWN));
        Assertions.assertEquals(new Position(2,1), ghosts.get(1).getPosition());
        Assertions.assertEquals(new Position(2,2), ghosts.get(2).getPosition());
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(FinalMenuState.class));
        Assertions.assertEquals(1100, controller.getLastMovement());
    }
    @Test
    void setGhostsStrats(){
        Assertions.assertEquals(null, ghosts.get(0).getStrat());
        Assertions.assertEquals(null, ghosts.get(1).getStrat());
        Assertions.assertEquals(null, ghosts.get(2).getStrat());
        Assertions.assertEquals(null, ghosts.get(3).getStrat());

         controller.setGhostStrats();

        Assertions.assertTrue(ghosts.get(0).getStrat() instanceof DengosoStrat);
        Assertions.assertTrue(ghosts.get(1).getStrat() instanceof AtchimStrat);
        Assertions.assertTrue(ghosts.get(2).getStrat() instanceof MestreStrat);
        Assertions.assertTrue(ghosts.get(3).getStrat() instanceof SonecaStrat);
    }
    @Test
    void getDirs(){
        walls = new ArrayList<>();
        Arena a2 = new Arena(5,5);
        a2.setWalls(walls);
        Ghost gh1 = new Ghost(1,1,NONE, CHASING);

        Assertions.assertEquals(4, controller.getDirs(a2,gh1).size());

        Assertions.assertEquals(3, controller.getDirs(a,g2).size());

        walls = new ArrayList<>();
        walls.add(new Wall(1,0));
        a2.setWalls(walls);
        Assertions.assertEquals(3, controller.getDirs(a2,gh1).size());


        walls = new ArrayList<>();
        walls.add(new Wall(2,1));
        a2.setWalls(walls);
        Assertions.assertEquals(3, controller.getDirs(a,gh1).size());
        Assertions.assertTrue(controller.getDirs(a2,g2).get(0).equals(LEFT));

        walls = new ArrayList<>();
        walls.add(new Wall(0,1));
        a2.setWalls(walls);
        Assertions.assertEquals(3, controller.getDirs(a2,gh1).size());
        Assertions.assertTrue(controller.getDirs(a2,g2).get(1).equals(UP));

    }
}
