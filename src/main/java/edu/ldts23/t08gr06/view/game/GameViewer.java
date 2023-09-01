package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.view.Viewer;
import edu.ldts23.t08gr06.view.gui.GUI;

import java.util.List;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 3), "Coins left: " + getModel().coinsLeft() + "}", "#FFFFFF");
        drawElements(gui, getModel().getWalls());
        drawElements(gui, getModel().getCollectibles());
        drawElements(gui, getModel().getGhosts());
        drawElement(gui, getModel().getPrincess(), new ElementViewer<Princess>('*', "#c8a2c8"));
        if (getModel().getDoor().isOpen()) drawElement(gui, getModel().getDoor(), new ElementViewer<Door>('_', "#964B00"));
        else drawElement(gui, getModel().getDoor(), new ElementViewer<Door>('_', "#34623f"));
    }

    <T extends Element> void drawElements(GUI gui, List<T> elements) {
        for (T element : elements)
            drawElement(gui, element, getViewer(element));
    }

    <T extends Element> ArenaViewer getViewer(T element) {
        if (element instanceof Flower) return new ElementViewer<Flower>('(', "#FFC0CB");
        if (element instanceof Princess) return new ElementViewer<Princess>('*', "#c8a2c8");
        if (element instanceof Cherry) return new ElementViewer<Cherry>(')', "#FF0000");
        if (element instanceof Coin) return new ElementViewer<Coin>('}', "#FFFF00");
        if (element instanceof Ghost) return new GhostViewer('{', ((Ghost) element).getState(), ((Ghost) element).getStrat());
        return new ElementViewer<Wall>('W', "#34623f");
    }
    <T extends Element> void drawElement(GUI gui, T element, ArenaViewer viewer) {
        viewer.draw(element, gui, viewer);
    }

}

