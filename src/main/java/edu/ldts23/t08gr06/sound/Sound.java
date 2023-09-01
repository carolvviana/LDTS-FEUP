package edu.ldts23.t08gr06.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Sound {
    private final String music;
    private Clip clip;
    public Sound(String music){
        this.music = music;
    }
    public void play(){
        try{
            URL resource = getClass().getClassLoader().getResource(music);
            File music = new File(resource.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(music.toURI()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
