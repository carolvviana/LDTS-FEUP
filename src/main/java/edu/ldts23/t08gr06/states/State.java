package edu.ldts23.t08gr06.states;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.Controller;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.gui.GUI;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel() {
        return model;
    }


    public void step(Game game, GUI gui, long time) throws IOException, LineUnavailableException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

}