package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.MenuController;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.menu.MenuViewer;


public class MenuState extends State<InitialMenu> {
        public MenuState(InitialMenu model) {
            super(model);
        }

        @Override
        protected Viewer<InitialMenu> getViewer() {
            return new MenuViewer(getModel());
        }

        @Override
        public Controller<InitialMenu> getController() {
            return new MenuController(getModel());
        }

}

