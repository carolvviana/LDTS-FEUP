package edu.ldts23.t08gr06;


import edu.ldts23.t08gr06.model.menu.InitialMenu;
import edu.ldts23.t08gr06.sound.Music;
import edu.ldts23.t08gr06.sound.Observer;
import edu.ldts23.t08gr06.states.MenuState;
import edu.ldts23.t08gr06.states.State;
import edu.ldts23.t08gr06.view.gui.LanternaGUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Observer> observers;

    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        observers = new ArrayList<>();
        this.gui = new LanternaGUI(40, 40);
        this.state = new MenuState(new InitialMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, LineUnavailableException, UnsupportedAudioFileException {
        new Game().start();
    }

    public void setState(State state)  {
        this.state = state;

        try {
            notifyObservers(state);
        }

        catch (IOException | LineUnavailableException | UnsupportedAudioFileException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public State getState() {return state;}
    private void notifyObservers(State state) throws IOException, LineUnavailableException, UnsupportedAudioFileException, URISyntaxException {
        for(Observer o : observers)
            o.update(state);
    }

    private void start() throws IOException, LineUnavailableException, UnsupportedAudioFileException, URISyntaxException {
        int FPS = 30;
        int frameTime = 1000 / FPS;
        new Music(this);

        while (this.state != null) {

            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
        System.exit(0);
    }
}