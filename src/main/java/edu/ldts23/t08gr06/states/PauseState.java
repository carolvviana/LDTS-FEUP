package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.PauseController;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.menu.PauseViewer;


public class PauseState extends State<PauseMenu> {


    public PauseState(PauseMenu pauseMenu) {
        super(pauseMenu);
    }

    @Override
    public Viewer<PauseMenu> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    public Controller<PauseMenu> getController() {
        return new PauseController(getModel());
    }

}


