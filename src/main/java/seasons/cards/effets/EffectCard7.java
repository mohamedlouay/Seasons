package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.Random;

/***
 * Avancez ou reculez le marqueur saison d'1 à 3 cases.
 * Les Bottes temporelles ne nécessitent aucun cristal et aucune énergie pour être invoquées.
 * Au moment où vous mettez en jeu les Bottes temporelles, avancez ou reculez d’une à trois cases le marqueur saison sur la roue des saisons.
 * Si les Bottes temporelles font reculer le marqueur saison de l’hiver à l’automne :
 * - reculez le marqueur année d’une case.
 * - conservez toutes les cartes pouvoir que vous avez en main.
 * Si les Bottes temporelles vous amènent à changer de saison (en avançant ou en reculant le marqueur saison),
 * les cartes affectées par le changement de saison comme Figrim l’avaricieux ou le Sablier du temps font immédiatement effet
 */

public class EffectCard7 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {
        Random random = new Random();
        int nbrMonth = random.nextInt(6) - 3;
        if (nbrMonth == 0) {
            nbrMonth = 3;
        }

        g.AddMois(nbrMonth);

        int oldSeason = g.getSeason();
        g.updateMonth();
        int newSeason = g.getSeason();

        if (oldSeason != newSeason) {
            g.update_invokedCardSeasonly();
            for (Card c : i.getInvokedcards()) {
                if ((c.getCardName().equals("Figrim l’Avaricieux") && (c.getCardName().equals("Sablier du temps")))){

                    g.getPlayers().get(0).getInventaire().setActivation(Effect_Activation_Mode.AT_PLAY);
                }
            }
        }
    }

        @Override
        public void onCrystalise (Inventaire i, Game g){

        }

        @Override
        public void onSeasonChange(Inventaire i, Game g){

        }

        @Override
        public void onEndOfYear(Inventaire i, Game g){

        }

    @Override
    public void onActivate(Inventaire i, Game g) {

    }
}

