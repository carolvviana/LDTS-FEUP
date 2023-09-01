package edu.ldts23.t08gr06.controllers.gamecontroller;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.DengosoStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.SonecaStrat;
import edu.ldts23.t08gr06.model.Direction;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.states.FinalMenuState;
import java.io.IOException;
import java.util.ArrayList;
import static edu.ldts23.t08gr06.model.Direction.*;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static java.lang.Integer.MAX_VALUE;

public class GhostController {
    Arena arena;
    private long lastMovement;
    public GhostController(Arena arena) {
        this.arena = arena;
    }

    public void step(Game game, long time) throws IOException {
        if (time - lastMovement > 300) {
            for (Ghost ghost : arena.getGhosts()) {
                chooseDir(getDirs(arena, ghost), ghost);
                if (arena.isEmpty(ghost.getPosition().addDirection(ghost.getDirection()))) ghost.setPosition(ghost.getPosition().addDirection(ghost.getDirection()));
                if (arena.isPrincess(ghost.getPosition())) {
                    if (ghost.getState()!=NUMB) {
                        game.setState(new FinalMenuState(new FinalMenu(false)));
                    }

                }
            }
            this.lastMovement = time;
        }
    }
    public long getLastMovement(){return this.lastMovement;}

    public void setGhostStrats(){
        arena.getGhosts().get(0).setStrat(new DengosoStrat(arena));
        arena.getGhosts().get(1).setStrat(new AtchimStrat(arena));
        arena.getGhosts().get(2).setStrat(new MestreStrat(arena));
        arena.getGhosts().get(3).setStrat(new SonecaStrat(arena));
    }

    public ArrayList<Direction> getDirs(Arena arena, Ghost ghost) {
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(RIGHT);
        directions.add(LEFT);
        directions.add(UP);
        directions.add(DOWN);


        for (Wall wall : arena.getWalls()) {
            if (ghost.getPosition().getRight().equals(wall.getPosition())){
                directions.remove(RIGHT);
            }
            if (ghost.getPosition().getLeft().equals(wall.getPosition())){
                directions.remove(LEFT);
            }
            if (ghost.getPosition().getUp().equals(wall.getPosition())){
                directions.remove(UP);
            }
            if (ghost.getPosition().getDown().equals(wall.getPosition())){
                directions.remove(DOWN);
            }

        }
        return directions;
    }

    public void chooseDir(ArrayList<Direction> aD,Ghost ghost) {
        Direction res = UP;
        double tmp;
        double min = MAX_VALUE;
        double acum = MAX_VALUE;
        int index = 0;
        int bestindex = 0;

        if (aD.size() == 1)
        {
            ghost.setDirection(aD.get(0));
        }
        else {
            for (Direction dir : aD) {
                tmp = ghost.getPosition().nextPositionWithDirection(dir).distance(ghost.getStrat().currentTarget(ghost.getState(), ghost.getPosition()));

                if (tmp == min) {
                    bestindex = index;
                    acum = min;
                } else if (tmp < min) {
                    res = dir;
                    min = tmp;
                }
                index++;
            }
        }

        if (min == acum)
            ghost.setDirection(dirPriority(aD, bestindex, min, ghost));
        ghost.setDirection(res);
    }


    private Direction dirPriority(ArrayList<Direction> aD, int index, double dist, Ghost ghost) {
        Direction dir1 = aD.get(index);
        Direction dir2 = UP;
        double tempdistance;

        if (aD.size() == 2)
            dir2 = aD.get(Math.abs(index - 1));
        else {
            int i = 0;
            for (Direction dir: aD) {
                tempdistance = ghost.getPosition().addDirection(dir).distance(ghost.getStrat().currentTarget(ghost.getState(), ghost.getPosition()));
                if (tempdistance == dist && i != index) {
                    dir2 = dir;
                    break;
                }
                i++;
            }
        }
        if (dir1.equals(UP) || dir2.equals(UP))
            return UP;
        if (dir1.equals(LEFT) || dir2.equals(LEFT))
            return LEFT;
        if (dir1.equals(DOWN) || dir2.equals(DOWN))
            return DOWN;
        return UP;
    }


}
