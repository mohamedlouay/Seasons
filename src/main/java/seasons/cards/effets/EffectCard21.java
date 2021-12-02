package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;
import seasons.player.Player;

import java.util.ArrayList;
import java.util.Random;


public class EffectCard21 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {
        ArrayList<Energy> E=new ArrayList<Energy>();
        Player p1;
        p1=g.getPlayers().get(new Random().nextInt(g.getPlayers().size()));
        while(p1==i.getPlayer())
            p1=g.getPlayers().get(new Random().nextInt(g.getPlayers().size()));
        for(int j=0;j<p1.getInventaire().getEnergies().size();j++) {
            E=p1.getInventaire().getEnergies();
        }
        i.setEnergies(E);


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
