package edu.ldts23.t08gr06.model;
import edu.ldts23.t08gr06.model.game.elements.fixed.Collectible;
import edu.ldts23.t08gr06.model.game.elements.fixed.Door;
import edu.ldts23.t08gr06.model.game.elements.fixed.Wall;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Cherry;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Coin;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.game.elements.moveable.Princess;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static edu.ldts23.t08gr06.model.Direction.NONE;
import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;

public class CustomMap extends MapBuilder{
    private final List<String> lines;

    public CustomMap(String mapName) throws IOException{

        URL resource = getClass().getClassLoader().getResource("maps/" + mapName + ".map");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    public int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    public int getHeight() {
        return lines.size();
    }

    @Override
    public List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'W') walls.add(new Wall(x +5, y +5));
        }
        return walls;
    }

    @Override
    public List<Ghost> createGhosts() {
        List<Ghost> ghosts = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                switch (line.charAt(x)){
                    case 'H', 'K', 'J','G' -> ghosts.add(new Ghost(x +5,y +5,NONE,CHASING));

                }
        }
        return ghosts;
    }

    @Override
    public List<Collectible> createCollectibles() {
        List<Collectible> collectibles = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                switch (line.charAt(x)){

                    case '$'-> collectibles.add(new Coin(x +5,y +5));
                    case 'C'-> collectibles.add(new Cherry(x +5,y +5));
                    case 'F'-> collectibles.add(new Flower(x +5,y +5));

                }
        }
        return collectibles;
    }
    @Override
    public Princess createPrincess(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Princess(x +5, y +5, UP);
        }
        return null;
    }
    @Override
    public Door createDoor() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D') return new Door(x +5, y +5);
        }
        return null;
    }
}
