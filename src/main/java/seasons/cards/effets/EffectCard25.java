package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;
import java.util.ArrayList;
import java.util.Random;
/***
 * Sacrifiez la Potion de savoir: recevez 5 energies.
 * sur Potion de savoir
 */


public class EffectCard25 extends Effect {

    @Override
    public void excute(Inventaire i, Game g) {
        Card temp = null;
        for (Card c : i.getInvokedcards()) {
            if (c.getCardName().equals("Potion de savoir")) {
                g.getDiscardPile().add(c);
                temp = c;

            }
        }
        i.getInvokedcards().remove(temp);
        i.getEnergies().add(Energy.getRandomEnergy());
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
