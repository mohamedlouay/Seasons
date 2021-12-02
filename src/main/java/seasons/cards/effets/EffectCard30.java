package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;


public class EffectCard30 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {


        if (i.getPlayer().wouldPlayCard()){
           i.getEnergies().add(Energy.getRandomEnergy());
           i.setEnergies(i.getEnergies());

        }


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

