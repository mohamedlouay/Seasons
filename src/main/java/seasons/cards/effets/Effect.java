package seasons.cards.effets;

import seasons.game.Game;
import seasons.inventaire.Inventaire;

public abstract class Effect {
    public abstract void excute(Inventaire i, Game g);
    public abstract void onCrystalise(Inventaire i, Game g);
    // a chaque changement de saison on applique l'effet defini dans cette methode
    public abstract void onSeasonChange(Inventaire i, Game g);
    // a chaque fin d'année on active le code qui se trouve dans cette methode
    public abstract void onEndOfYear(Inventaire i, Game g);

    public abstract void onActivate(Inventaire i,Game g);
}
