package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.controllers.gamecontroller.GameController;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena model) {
        super(model);
    }
    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    public Controller<Arena> getController() {
        return new GameController(getModel());
    }


}
