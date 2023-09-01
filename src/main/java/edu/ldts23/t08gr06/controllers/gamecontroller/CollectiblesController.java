package edu.ldts23.t08gr06.controllers.gamecontroller;

import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.sound.Sound;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;

public class  CollectiblesController {
    private List<Collectible> activeCollectibles = new ArrayList<>();
    private Arena arena;
    private long timeSinceState;
    int counter;
    private final Sound flower_sound;
    private final Sound cherry_sound;

    public CollectiblesController(Arena arena) {
        this.arena = arena;
        this.timeSinceState = 0;
        this.counter = 100;
        this.cherry_sound = new Sound("sounds/cherry.wav");
        this.flower_sound = new Sound("sounds/flower.wav");
    }

    public void step() throws IOException {
        Position position = arena.getPrincess().getPosition();

        if (arena.isFlower(position)){
            flower_sound.play();
        }
        if (arena.isCherry(position)) {
            arena.removeGhost();
            cherry_sound.play();
            arena.removeCollectible(position);
        }
        if (arena.isCoin(position)) {
            arena.removeCollectible(position);
        }
    }
    public long getTimeSinceState(){ return this.timeSinceState;}
    public void stepFlower(long time){

        List<Collectible> tmpCollectibles = new ArrayList<Collectible>(arena.getCollectibles());
        for(Collectible c : tmpCollectibles){
            if(c.getPosition().equals(arena.getPrincess().getPosition())){
                arena.numbGhosts();
                activeCollectibles.add(c);
            }
        }

        List<Collectible> tmpActiveCollectibles = new ArrayList<Collectible>(activeCollectibles);
        for(Collectible col : tmpActiveCollectibles){
            if(time - timeSinceState > 1000){
                col.decreaseCounter();
                if(col.getCounter() <= 0){
                    for (Ghost g : arena.getGhosts()) {
                        g.setState(CHASING);
                    }
                    activeCollectibles.remove(col);
                }
                this.timeSinceState = time;
            }
        }
    }
}

