package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

/***
 * Pour activer la Potion de vie, sacrifiez-la afin de cristalliser
 * chacune de vos énergies en 4 cristaux. Avancez votre pion
 * du sorcier d’autant de cases que nécessaire sur la piste des
 * cristaux
 */

public class EffectCard26 extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        Card cardTmp = null;
        for (Card c : i.getInvokedcards())
        {
            if (c.getCardName().equals("Potion de vie"))
            {
                g.getDiscardPile().add(c);
                cardTmp=c;

            }
        }
        i.getInvokedcards().remove(cardTmp);
        // pour chaque energie , ganger  4 cristaux
        i.addCrystals(i.getEnergies().size()*4);
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
