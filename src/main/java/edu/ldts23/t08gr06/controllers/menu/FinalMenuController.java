package edu.ldts23.t08gr06.controllers.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.view.gui.GUI;

import java.io.IOException;

public class FinalMenuController extends Controller<FinalMenu> {

    public FinalMenuController(FinalMenu finalmenu) {
        super(finalmenu);
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
                if (getModel().getCurrentEntry() == getModel().getNumberEntries() - 1) {game.setState(null);}
                else game.setState(new MenuState(new InitialMenu()));
                break;
            default: break;
        }
    }
}
