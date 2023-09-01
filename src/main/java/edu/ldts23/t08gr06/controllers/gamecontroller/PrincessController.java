package edu.ldts23.t08gr06.controllers.gamecontroller;
import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.states.FinalMenuState;
import edu.ldts23.t08gr06.view.gui.GUI;
import static edu.ldts23.t08gr06.model.Direction.*;

public class PrincessController {

    private Arena arena;

    public PrincessController(Arena arena) {
        this.arena = arena;
    }

    public void movePrincessLeft(Game game) {
        movePrincess(game, arena.getPrincess().getPosition().getLeft());
    }

    public void movePrincessRight(Game game) {
        movePrincess(game, arena.getPrincess().getPosition().getRight());
    }

    public void movePrincessUp(Game game) {
        movePrincess(game, arena.getPrincess().getPosition().getUp());
    }

    public void movePrincessDown(Game game) {
        movePrincess(game, arena.getPrincess().getPosition().getDown());
    }

    private void movePrincess(Game game, Position position) {
        if (arena.isNotWall(position) && (!arena.isDoor(position) || arena.getDoor().isOpen())) {
            if (arena.isNotWall(position) && (!arena.isDoor(position) || arena.getDoor().isOpen())) {
                arena.getPrincess().setPosition(position);


                if (arena.isEnemy(arena.getPrincess().getPosition())) {
                    System.out.println("GAMEOVER");
                    game.setState(new FinalMenuState(new FinalMenu(false)));
                }

                if (arena.isDoor(arena.getPrincess().getPosition()) && arena.getDoor().isOpen()) {
                    game.setState(new FinalMenuState(new FinalMenu(true)));

                }
            }
        }
    }

    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            arena.getPrincess().setDirection(UP);
            movePrincessUp(game);
        }
        if (action == GUI.ACTION.RIGHT) {
            arena.getPrincess().setDirection(RIGHT);
            movePrincessRight(game);
        }
        if (action == GUI.ACTION.DOWN) {
            arena.getPrincess().setDirection(DOWN);
            movePrincessDown(game);
        }
        if (action == GUI.ACTION.LEFT) {
            arena.getPrincess().setDirection(LEFT);
            movePrincessLeft(game);
        }
    }

}