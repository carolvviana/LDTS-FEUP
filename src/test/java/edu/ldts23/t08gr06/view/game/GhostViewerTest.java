package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.DengosoStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.SonecaStrat;
import edu.ldts23.t08gr06.model.game.arena.Arena;
import edu.ldts23.t08gr06.model.game.elements.moveable.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.CHASING;
import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;
import static org.junit.jupiter.api.Assertions.*;

public class GhostViewerTest {
    Ghost g1, g2, g3, g4, g5;
    @BeforeEach
    void setUp(){
        g1 = Mockito.mock(Ghost.class);
        Mockito.when(g1.getStrat()).thenReturn(new AtchimStrat(new Arena(10,10)));
        Mockito.when(g1.getState()).thenReturn(CHASING);
        g2 = Mockito.mock(Ghost.class);
        Mockito.when(g2.getStrat()).thenReturn(new MestreStrat(new Arena(10,10)));
        Mockito.when(g2.getState()).thenReturn(CHASING);
        g3 = Mockito.mock(Ghost.class);
        Mockito.when(g3.getStrat()).thenReturn(new DengosoStrat(new Arena(10,10)));
        Mockito.when(g3.getState()).thenReturn(CHASING);
        g4 = Mockito.mock(Ghost.class);
        Mockito.when(g4.getStrat()).thenReturn(new SonecaStrat(new Arena(10,10)));
        Mockito.when(g4.getState()).thenReturn(CHASING);
        g5 = Mockito.mock(Ghost.class);
        Mockito.when(g5.getStrat()).thenReturn(new AtchimStrat(new Arena(10,10)));
        Mockito.when(g5.getState()).thenReturn(NUMB);
    }

    @Test
    void GhostClass(){
        GhostViewer gv1 = new GhostViewer('G', g1.getState(), g1.getStrat());
        GhostViewer gv2 = new GhostViewer('G', g2.getState(), g2.getStrat());
        GhostViewer gv3 = new GhostViewer('G', g3.getState(), g3.getStrat());
        GhostViewer gv4 = new GhostViewer('G', g4.getState(), g4.getStrat());
        GhostViewer gv5 = new GhostViewer('G', g5.getState(), g5.getStrat());

        assertEquals('G', gv1.getChar2());
        assertEquals('G', gv2.getChar2());
        assertEquals('G', gv3.getChar2());
        assertEquals('G', gv4.getChar2());
        assertEquals('G', gv5.getChar2());

        assertEquals("#FFFF00", gv1.getColor2());
        assertEquals("#FFC0CB", gv2.getColor2());
        assertEquals("#89CFF0", gv3.getColor2());
        assertEquals("#7CFC00", gv4.getColor2());
        assertEquals("#FFFFFF", gv5.getColor2());

        assertFalse(gv1.getBackground(g1));
    }
}
