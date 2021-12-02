package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public class EffectCard22 extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        AddCrystals cube = new AddCrystals(-20);
    }

    @Override
    public void onCrystalise(Inventaire i, Game g) {

    }

    @Override
    public void onSeasonChange(Inventaire i, Game g) {

    }

    @Override
    public void onEndOfYear(Inventaire i, Game g) {
        if(g.getMois() == 36){
            AddCrystals cube = new AddCrystals(30);
        }

    }

    @Override
    public void onActivate(Inventaire i, Game g) {

    }
}
