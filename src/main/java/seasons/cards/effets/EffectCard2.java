package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Game;
import seasons.inventaire.Inventaire;
import seasons.player.Player;

import java.util.ArrayList;

/***
 * Piochez 4 cartes pouvoir : placez-en une dans votre main et défaussez les cartes restantes.
 * sur l’Amulette de feu
 */

public class EffectCard2 extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        ArrayList<Card> PowerCards ;

        //piocher 4 cartes pouvoir
        PowerCards =(ArrayList<Card>) g.getAllcards().subList(g.getAllcards().size()-3,g.getAllcards().size());
        g.getAllcards().removeAll(PowerCards);

        for (Player p :g.getPlayers()) {
            p.addCard(PowerCards.get(PowerCards.size()-1));

            if (i.getStars()>= 1 ) //deffausse les 4 cartes
            {
                i.invokeACard(PowerCards.get(0));

            }

            g.getDiscardPile().addAll(PowerCards);

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
