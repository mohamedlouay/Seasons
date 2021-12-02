package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public class EffectCard27 extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {

    }

    @Override
    public void onCrystalise(Inventaire i, Game g) {

    }

    @Override
    public void onSeasonChange(Inventaire i, Game g) {
        i.getEnergies();

    }

    @Override
    public void onEndOfYear(Inventaire i, Game g) {

    }

    @Override
    public void onActivate(Inventaire i, Game g) {

    }
}
