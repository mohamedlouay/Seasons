package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public class PowerEffect extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        // a l'excution on pioche une carte et on augmante la jauge d'invocation de 2
        g.drawAcard(i);
        i.addAvocation(2);
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
        g.drawAcard(i);
        i.addAvocation(2);
    }
}
