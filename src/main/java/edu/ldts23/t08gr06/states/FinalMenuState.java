package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.controllers.menu.FinalMenuController;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.menu.FinalMenuViewer;


public class FinalMenuState extends State<FinalMenu> {

    public FinalMenuState(FinalMenu finalmenu) {
        super(finalmenu);

    }

    @Override
    protected Viewer<FinalMenu> getViewer() {
        return new FinalMenuViewer(getModel());
    }

    @Override
    public Controller<FinalMenu> getController() {
        return new FinalMenuController(getModel());
    }


}

