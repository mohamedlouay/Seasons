package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.Random;

/***
 * recevez 4  énergies de votre choix en provenance du stock et placez-les
 * sur l’Amulette d’eau
 */
public class EffectCard4 extends Effect {
    @Override
    public void excute(Inventaire i, Game g) {
        //pour le moment , le jouer recoit les 4 energies directement sur son inventaire .
        //pour le moment ,le joueur ne fait pas le choix encore
        i.getEnergies().addAll(this.EnergiesChoice());
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


    protected ArrayList<Energy> EnergiesChoice() {
        ArrayList<Energy> energiesRandom = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Random random = new Random();

            switch (random.nextInt(4)) {

                case 0:
                    energiesRandom.add(Energy.FIRE);
                    break;
                case 1:
                    energiesRandom.add(Energy.WIND);
                    break;
                case 2:
                    energiesRandom.add(Energy.EARTH);
                    break;
                default:
                    energiesRandom.add(Energy.WATER);


            }

        }
        return energiesRandom;
    }

}
