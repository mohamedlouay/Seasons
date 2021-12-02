package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;


public class EffectCard18 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {

        ArrayList<Energy> E= new ArrayList<Energy>();

        i.getEnergies().add(Energy.getRandomEnergy());
        i.getEnergies().add(Energy.getRandomEnergy());
        i.setEnergies(i.getEnergies());

    }

    @Override
    public void onCrystalise (Inventaire i, Game g){

    }

    @Override
    public void onSeasonChange(Inventaire i, Game g){

    }

    @Override
    public void onEndOfYear(Inventaire i, Game g){

    }

    @Override
    public void onActivate(Inventaire i, Game g) {

    }
}

