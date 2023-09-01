package edu.ldts23.t08gr06.controllers.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.view.gui.GUI;

import java.io.IOException;

public class PauseController extends Controller<PauseMenu> {

    public PauseController(PauseMenu pauseMenu) {
        super(pauseMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                switch (getModel().getCurrentEntry()){
                    case 0:
                        game.setState(getModel().getNextState()); break;
                    case 1:
                        game.setState(new MenuState(new InitialMenu())); break;
                    case 2:
                        game.setState(null);
                }
                break;
            default: break;
        }
    }
}
