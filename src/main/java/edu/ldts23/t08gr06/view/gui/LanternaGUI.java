package edu.ldts23.t08gr06.view.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import edu.ldts23.t08gr06.model.Position;
import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.view.game.ArenaViewer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI extends GUI {

    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        setHeight(height); setWidth(width);
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/NewFont4.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q')) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == ' ' || keyStroke.getCharacter() == 'P')) return ACTION.PAUSE;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        return ACTION.NONE;
    }


    @Override
    public void clear() {screen.clear();}

    @Override
    public void refresh() throws IOException {screen.refresh();}

    @Override
    public void close() throws IOException {screen.close();}
    TextGraphics drawElement(int x, int y, char c, String color, boolean flag) {
        TextGraphics tg = screen.newTextGraphics();
        if (flag) tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, "" + c);
        return tg;
    }

    @Override
    public void drawElement(Element element, ArenaViewer viewer){
        drawElement(element.getPosition().getX(), element.getPosition().getY(), viewer.getChar2(), viewer.getColor2(), viewer.getBackground(element));
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawFrame() {
        int height = getHeight();
        int width = getWidth();

        for (int c = 0; c < width; c++) {
            drawElement(c, 0, '#', "#1e2f23", true);
            drawElement(c, height-1 , '#' , "#1e2f23", true);
        }
        for (int r = 0; r < height - 1; r++) {
            drawElement(0, r, '#', "#1e2f23", true);
            drawElement(width-1, r, '#', "#1e2f23", true);
        }

        for (int c = 1; c < width-1; c++) {
            drawElement(c, 1, '#', "#7eb77f", true);
            drawElement(c, height-2 , '#' , "#7eb77f", true);
        }

        for (int r = 1; r < height-1; r++) {
            drawElement(1, r, '#', "#7eb77f", true);
            drawElement(width-2, r, '#', "#7eb77f", true);
        }
    }
}
