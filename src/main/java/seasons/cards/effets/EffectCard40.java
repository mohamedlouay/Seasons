package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;


public class EffectCard40 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {
        ArrayList<Energy> E = new ArrayList<Energy>();
        for (int j=0;j<g.getPlayers().size();j++) {
            if (i.getPlayer() != g.getPlayers().get(j)) {

                for (int t = 0; t < g.getPlayers().get(j).getEnergiesACrystaliser(i,g.getSeason()).size(); t++) {
                    E.add(Energy.WIND);
                }
                g.getPlayers().get(j).getInventaire().setEnergies(E);

            }
        }


    }

    @Override
    public void onCrystalise(Inventaire i, Game g) {

    }

    @Override
    public void onSeasonChange(Inventaire i, Game g) {

    }

    @Override
    public void onEndOfYear(Inventaire i, Game g) {

    }

    @Override
    public void onActivate(Inventaire i, Game g) {

    }


}
