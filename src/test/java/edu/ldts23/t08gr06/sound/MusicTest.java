package edu.ldts23.t08gr06.sound;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import edu.ldts23.t08gr06.model.menu.FinalMenu;
import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.model.menu.PauseMenu;
import edu.ldts23.t08gr06.states.FinalMenuState;
import edu.ldts23.t08gr06.states.GameState;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.states.PauseState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static edu.ldts23.t08gr06.model.Direction.UP;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;

public class MusicTest {
    Arena a;
    @Test
    void constructor(){
        Game g = Mockito.mock(Game.class);
        try {
            Music m = new Music(g);
            Mockito.verify(g, Mockito.times(1)).addObserver(m);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void update() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
        Game game = Mockito.mock(Game.class);
        Music music = Mockito.spy(new Music(game));
        a = new Arena(10, 10);
        a.setGhosts(Arrays.asList(new Ghost(4, 5, UP, CHASING),new Ghost(5, 6, UP, CHASING), new Ghost(6, 7, UP, CHASING), new Ghost(7, 8, UP, CHASING)));

        music.update(new GameState(a));
        Mockito.verify(music, Mockito.times(1)).startMusic("sounds/game.WAV");
        music.update(new MenuState(new InitialMenu()));
        Mockito.verify(music, Mockito.times(1)).startMusic("sounds/mainmenu.WAV");
        music.update(new PauseState(new PauseMenu(new GameState(a))));
        Mockito.verify(music, Mockito.times(1)).startMusic("sounds/pause.WAV");
        music.update(new FinalMenuState(new FinalMenu(true)));
        Mockito.verify(music, Mockito.times(1)).startMusic("sounds/end.WAV");
    }
}
