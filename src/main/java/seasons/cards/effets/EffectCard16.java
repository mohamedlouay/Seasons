package seasons.cards.effets;

import seasons.cards.Card;
import seasons.game.Game;
import seasons.inventaire.Inventaire;
import seasons.player.Player;

import java.util.Random;



public class EffectCard16 extends Effect {

    private void destructeurEffect(Inventaire i, Game g) {
        if(i.getEnergies().size()>=1){
            i.getEnergies().remove(new Random().nextInt( i.getEnergies().size()));
            for (Player p : g.getPlayers()){
                if(p!= i.getPlayer()){
                    p.getInventaire().subtractCrystals(4);
                }

            }
        }
    }

    @Override
    public void excute(Inventaire i, Game g) {
        destructeurEffect(i, g);
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
        destructeurEffect(i, g);
    }
}