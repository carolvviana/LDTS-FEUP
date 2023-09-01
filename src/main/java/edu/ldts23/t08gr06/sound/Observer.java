package edu.ldts23.t08gr06.sound;

import edu.ldts23.t08gr06.Game;
import edu.ldts23.t08gr06.states.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Observer {
    protected Game game;

    public abstract void update(State state) throws IOException, LineUnavailableException, UnsupportedAudioFileException, URISyntaxException;
}
