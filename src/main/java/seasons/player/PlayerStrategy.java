package seasons.player;

import seasons.cards.Card;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;

public interface PlayerStrategy {

    face choisirUndes(ArrayList<face> faces, Inventaire i );

    boolean keepTheCard(int mois);

    boolean veutCystaliser(Inventaire i , int saison);

    ArrayList<Energy> getEnergiesACrystaliser(ArrayList<Energy> energies,int saison);

    boolean wouldPlayCard(ArrayList<Card> cards,Inventaire i);
    boolean wouldPlayCardAgain(ArrayList<Card> cards,Inventaire i);


    Card jouerUneCarte(ArrayList<Card> cards,int mois,Inventaire i);


    void switchEnergy(Inventaire inventaire, Energy energy);

    Boolean wouldActivateCard(ArrayList<Card> cards, int stars);

    Card ActivateACard(ArrayList<Card> cards, int stars);
}
