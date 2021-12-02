package seasons.cards.effets;

import seasons.cards.Card;
import seasons.cards.Type;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EffectCard17 extends Effect{

    @Override
    public void excute(Inventaire i, Game g) {
        List<Card> magicCard = null;
        for (int j=0;j<g.getPlayers().size();j++) {

            magicCard = g.getPlayers().get(j).getInventaire().getInvokedcards().stream().filter(n -> (n.getType() == Type.MAGIQUES)).collect(Collectors.toList());
            if (magicCard.size() != 0) {
                g.getPlayers().get(j).getCards().add(magicCard.get(0));
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

