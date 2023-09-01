package edu.ldts23.t08gr06.controllers.menu;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.model.CustomMap;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.view.gui.GUI;

import java.io.IOException;

public class MenuController extends Controller<InitialMenu> {
        public MenuController(InitialMenu initialMenu) {
            super(initialMenu);
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
                    else {game.setState(new GameState(new CustomMap("map" + (getModel().getCurrentEntry() + 1)).createArena()));}
                    break;
                default: break;
            }
        }
}

