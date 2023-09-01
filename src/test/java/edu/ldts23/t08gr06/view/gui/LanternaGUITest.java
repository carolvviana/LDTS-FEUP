package edu.ldts23.t08gr06.view.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.elements.fixed.collectible.Flower;
import edu.ldts23.t08gr06.view.game.ElementViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }
 @Test
 void getNextAction() throws IOException{
     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
     Assertions.assertEquals(GUI.ACTION.QUIT, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
     Assertions.assertEquals(GUI.ACTION.UP, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
     Assertions.assertEquals(GUI.ACTION.RIGHT, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
     Assertions.assertEquals(GUI.ACTION.DOWN, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
     Assertions.assertEquals(GUI.ACTION.LEFT, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
     Assertions.assertEquals(GUI.ACTION.SELECT, gui.getNextAction());

     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('q', true, true));
     Assertions.assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(' ', true, true));
     Assertions.assertEquals(GUI.ACTION.PAUSE, gui.getNextAction());
     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('Q', true, true));
     Assertions.assertEquals(GUI.ACTION.QUIT, gui.getNextAction());
     Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('P', true, true));
     Assertions.assertEquals(GUI.ACTION.PAUSE, gui.getNextAction());
     Mockito.when(screen.pollInput()).thenReturn(null);
     Assertions.assertEquals(GUI.ACTION.NONE, gui.getNextAction());
 }
    @Test
    void drawElement(){
        gui.drawElement(1,2,'C', "#FFFFFF", true);

        Mockito.verify(tg, Mockito.atMostOnce()).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1,2,""+'C');

    }
    @Test
    void drawElementView(){
        gui.drawElement(new Flower(1,2), new ElementViewer<Flower>('F', "#FFFFFF"));

        Mockito.verify(tg, Mockito.never()).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1,2,""+'F');
    }
    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "PacPrincess", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "PacPrincess");
    }

    @Test
    void drawFrame(){
        LanternaGUI guiSpy = Mockito.spy(gui);

        guiSpy.drawFrame();

        int height = guiSpy.getHeight();
        int width = guiSpy.getWidth();

        Mockito.verify(guiSpy, Mockito.times(2*width)).drawElement(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyChar(), Mockito.anyString(), Mockito.anyBoolean() );
        Mockito.verify(guiSpy, Mockito.times(2*height)).drawElement(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyChar(), Mockito.anyString(), Mockito.anyBoolean() );
    }



}
