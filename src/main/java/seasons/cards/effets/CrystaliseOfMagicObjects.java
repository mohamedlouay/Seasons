package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public class CrystaliseOfMagicObjects extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        for(int index =0 ;index < i.getInvokedcards().size();index++){
            i.addCrystals(3);
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
