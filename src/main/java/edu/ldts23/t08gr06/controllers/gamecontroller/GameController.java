package edu.ldts23.t08gr06.controllers.gamecontroller;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.states.PauseState;
import edu.ldts23.t08gr06.view.gui.GUI;

import java.io.IOException;

public class GameController extends Controller<Arena> {

        private final CollectiblesController collectiblesController;
        private final PrincessController princessController;
        private final GhostController ghostController;

        public GameController(Arena arena) {
            super(arena);
            this.ghostController = new GhostController(arena);
            ghostController.setGhostStrats();
            this.princessController = new PrincessController(arena);
            this.collectiblesController = new CollectiblesController(arena);
        }
    public GameController(Arena a, GhostController gc, PrincessController pc, CollectiblesController cc) {
        super(a);
        this.ghostController = gc;
        ghostController.setGhostStrats();
        this.princessController = pc;
        this.collectiblesController = cc;
    }


        @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            if (action == GUI.ACTION.QUIT)
            {
                game.setState(new MenuState(new InitialMenu()));
            }
            else if (action == GUI.ACTION.PAUSE) {
                game.setState(new PauseState(new PauseMenu(game.getState())));
            }
            else {
                collectiblesController.step();
                collectiblesController.stepFlower(time);
                princessController.step(game, action, time);
                ghostController.step(game,  time);
                if (getModel().coinsLeft() == 0) getModel().openDoor();
            }
        }

}
