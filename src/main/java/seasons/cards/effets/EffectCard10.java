package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.Random;

public class EffectCard10 extends Effect{

        @Override
        public void excute(Inventaire i, Game g) {

              for (int j=0;j<g.getPlayers().size();j++)
                if (i.getPlayer()!=g.getPlayers().get(j)){
                    if (g.getPlayers().get(j).getCards().size()!=0) {
                         g.getPlayers().get(j).getCards().remove(new Random().nextInt(g.getPlayers().get(j).getCards().size()));
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

    }
}

