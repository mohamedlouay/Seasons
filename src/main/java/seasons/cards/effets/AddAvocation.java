package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public class AddAvocation extends Effect{
    int n;
    public AddAvocation(int n){
        this.n=n;
    }
    @Override
    public void excute(Inventaire i, Game g) {
        i.addAvocation(n);




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