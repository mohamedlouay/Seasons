package seasons.cards.effets;

import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;

public class AddTreeTimesCrystals   extends Effect {
    int x;

    public AddTreeTimesCrystals() {
        this.x+=9;
    }


    @Override
    public void excute(Inventaire i, Game g) {
        BalanceEffect(i, g);


    }

    private void BalanceEffect(Inventaire i, Game g) {
        int compteur;
        for(int index = 0; index< i.getEnergies().size(); index ++) {
            compteur =0;
            ArrayList<Energy> ec = new ArrayList<>();
           for (int j = 0; j < i.getEnergies().size() && compteur < 3; j++) {
                if(j==index){ j ++;}
                else if (i.getEnergies().get(index) == i.getEnergies().get(j)) {
                    ec = i.getPlayer().getEnergiesACrystaliser(i, g.getSeason());
                    compteur += 1;
                }
                if(compteur == 3){
                    i.AddTreeTimesCrystals();
                    i.getEnergies().removeAll(ec);
                }
            }

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
        BalanceEffect(i, g);
    }
}
