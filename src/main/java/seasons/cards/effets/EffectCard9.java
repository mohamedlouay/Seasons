package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;

/***
 * Au moment où vous invoquez le Calice divin, piochez 4 cartes
 * pouvoir et invoquez-en une gratuitement, sans payer son coût
 * d’invocation. Cette carte pouvoir ainsi invoquée ne déclenche pas
 * l’effet de l’Arcano Sangsue, du Bâton du printemps et du Vase
 * oublié d’Yjang. Placez les 3 cartes restantes dans la défausse.
 *  Vous devez posséder une jauge d’invocation suffisante pour pouvoir
 * invoquer cette nouvelle carte. Dans le cas contraire, la carte piochée est
 * défaussée.
 */
public class EffectCard9 extends Effect{
    @Override
    public void excute(Inventaire i, Game g) {
        ArrayList<Card> fourCards = new ArrayList<>();
        //piocher 4 cartes
        for (int j = 0; j < 4; j++) {
            fourCards.add(g.getAllcards().get(j));
            g.getAllcards().remove(j);

        }
        i.addPickedCard();

        //pour le moment , le joueur choisit la 1ere  carte , apres on ajoute les strategies des joueur

        if (i.getStars()>= 1 ) // si le joueur peut invoquer encore sinon on deffausse les 4 cartes
        {
            i.invokeACard(fourCards.get(0));

        }

        g.getDiscardPile().addAll(fourCards);
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
