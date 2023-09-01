package edu.ldts23.t08gr06.model;

import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;

import java.util.List;

public abstract class MapBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPrincess(this.createPrincess());
        arena.setGhosts(this.createGhosts());
        arena.setWalls(this.createWalls());
        arena.setCollectibles(this.createCollectibles());
        arena.setDoor(this.createDoor());

        return arena;
    }
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract List<Wall> createWalls();
    public abstract List<Ghost> createGhosts();
    public abstract List<Collectible> createCollectibles();
    public abstract Princess createPrincess();
    public abstract Door createDoor();
}
