package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.Random;


public class EffectCard37 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {
        dragonEffect(i);


    }

    private void dragonEffect(Inventaire i) {
        for(int j=0;j<3;j++) {
            if (i.getPlayer().getCards().size()!=0)
            i.getPlayer().getCards().remove(new Random().nextInt((i.getPlayer().getCards().size())));
        }
        i.getPlayer().getInventaire().addCrystals(15);
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
        dragonEffect(i);
    }


}
