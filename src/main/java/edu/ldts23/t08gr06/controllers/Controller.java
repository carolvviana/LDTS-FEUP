package edu.ldts23.t08gr06.controllers;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.view.gui.GUI;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game main, GUI.ACTION action, long time) throws IOException;
}
