package edu.ldts23.t08gr06.view.game;

import edu.ldts23.t08gr06.controllers.gamecontroller.GhostStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.AtchimStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.DengosoStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.MestreStrat;
import edu.ldts23.t08gr06.controllers.ghoststrat.SonecaStrat;
import edu.ldts23.t08gr06.model.game.elements.Element;
import edu.ldts23.t08gr06.model.game.elements.moveable.GhostState;

import static edu.ldts23.t08gr06.model.game.elements.moveable.GhostState.NUMB;

public class GhostViewer extends ArenaViewer{

    private String color;

    public GhostViewer(char letter, GhostState state, GhostStrat strat ){
        super(letter);
        if (strat instanceof AtchimStrat) this.color = "#FFFF00";
        if (strat instanceof MestreStrat) this.color = "#FFC0CB";
        if (strat instanceof DengosoStrat) this.color ="#89CFF0";
        if (strat instanceof SonecaStrat) this.color = "#7CFC00";

        if (state == NUMB){
            this.color = "#FFFFFF";
        }
    }
    @Override
    public String getColor2(){return this.color;}

    @Override
    public char getChar2(){return this.letter;}

    @Override
    public boolean getBackground(Element e){
        return false;
    }
}
