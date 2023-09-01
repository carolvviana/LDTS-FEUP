package edu.ldts23.t08gr06.sound;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.states.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Music extends Observer {
    private Clip clip;
    public Music(Game gamem) throws LineUnavailableException, URISyntaxException, UnsupportedAudioFileException, IOException {
        this.game = gamem;
        this.game.addObserver(this);
        startMusic("sounds/mainmenu.WAV");
    }
    public void startMusic(String path) throws URISyntaxException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        URL resource = getClass().getClassLoader().getResource(path);
        File music = new File(resource.toURI());
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(music.toURI()));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-15.0f);
    }

    @Override
    public void update(State state) throws IOException, LineUnavailableException, UnsupportedAudioFileException, URISyntaxException {
        clip.stop();
        clip.close();

        if (state instanceof MenuState) {
            startMusic("sounds/mainmenu.WAV");
        } else if (state instanceof PauseState) {
            startMusic("sounds/pause.WAV");
        }
        else if (state instanceof GameState) {
            startMusic("sounds/game.WAV");
        }
        else if (state instanceof FinalMenuState) {
            startMusic("sounds/end.WAV");
        }
    }

}
