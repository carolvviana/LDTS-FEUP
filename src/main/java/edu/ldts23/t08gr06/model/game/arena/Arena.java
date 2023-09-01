package edu.ldts23.t08gr06.model.game.arena;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import java.util.List;
import java.util.Random;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class Arena {
    private final int width;
    private final int height;
    private Princess princess;
    private List<Ghost> ghosts;
    private List<Wall> walls;
    private List<Collectible> collectibles;
    private Door door;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Princess getPrincess() {
        return princess;
    }
    public void setPrincess(Princess princess) {
        this.princess = princess;
    }
    public List<Ghost> getGhosts() {
        return ghosts;
    }
    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public Door getDoor(){return door;}
    public void setDoor(Door door){this.door = door;}

    public int coinsLeft(){
        int counter = 0;
        for (Collectible c : collectibles)
        {if (c instanceof Coin) counter++;}
        return counter;
    }

    public boolean isEnemy(Position position) {
        for (Ghost ghost : ghosts)
            if (ghost.getPosition().equals(position) && ghost.getState()==CHASING)
                return true;
        return false;
    }
    public boolean isPrincess(Position position) {
            if (princess.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isFlower(Position position) {
        for (Collectible c : collectibles)
            if (c instanceof Flower){
                if (c.getPosition().equals(position)) return true;
            }
        return false;
    }
    public boolean isCherry(Position position) {
        for (Collectible c : collectibles)
            if (c instanceof Cherry){
                if (c.getPosition().equals(position)) return true;
            }
        return false;
    }
    public boolean isCoin(Position position) {
        for (Collectible c : collectibles)
            if (c instanceof Coin){
                if (c.getPosition().equals(position)) return true;
            }
        return false;
    }

    public void removeGhost(){
        Random rand = new Random();
        int index = rand.nextInt(ghosts.size());
        ghosts.remove(index);
    }
    public List<Collectible> getCollectibles() {
        return collectibles;
    }

    public void setCollectibles(List<Collectible> collectibles) {
        this.collectibles = collectibles;
    }
    public boolean isNotWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;

        for (Ghost g: ghosts){
            if (g.getPosition().equals(position)) return false;
        }
        return !isDoor(position);
    }

    public boolean isDoor(Position position){
        if (door.getPosition().equals(position))
            return true;
        return false;
    }

    public void removeCollectible(Position position){
        for (int i = 0; i<collectibles.size(); i++){
            if (collectibles.get(i).getPosition().equals(position)) collectibles.remove(i);
        }
    }
    public Collectible getCollectibleAt(Position position){
        for (Collectible c: collectibles){
            if (c.getPosition().equals(position)){
                return c;
            }
        }
        return null;
    }
    public void numbGhosts(){
        for (Ghost g: getGhosts()){
            g.setState(NUMB);
        }
        removeCollectible(princess.getPosition());
    }
    public void openDoor(){
        door.openDoor();
    }

}
