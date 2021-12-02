package seasons.player;

import io.cucumber.java.bs.I;
import io.cucumber.java.sl.In;
import seasons.cards.Card;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.Random;

public class RandomStrategy implements PlayerStrategy {
    Random random;
    public RandomStrategy(){
        random=new Random();

    }
    public void setRandom(Random r){
        random=r;
    }

    @Override
    public face choisirUndes(ArrayList<face> faces , Inventaire i ) {
        return faces.get(random.nextInt(faces.size()));
    }

    @Override
    public boolean keepTheCard(int mois) {
        return true;
    }


    @Override
    public boolean veutCystaliser(Inventaire i , int saison) {
        return true;
    }

    @Override
    public ArrayList<Energy> getEnergiesACrystaliser(ArrayList<Energy> energies,int saison) {
        return energies;
    }

    @Override
    public boolean wouldPlayCard(ArrayList<Card> cards, Inventaire i) {
        return true;
    }
    @Override
    public boolean wouldPlayCardAgain(ArrayList<Card> cards, Inventaire i) {
        return false;
    }

    @Override
    public Card jouerUneCarte(ArrayList<Card> cards, int mois, Inventaire i) {

        if (cards.size() != 0) { // le joueur a des cartes
            return cards.get(0);
        }
        else
            return null ;
    }

    @Override
    public void switchEnergy(Inventaire inventaire, Energy energy) {
        //remove the first energy
        inventaire.getEnergies().remove(0);
        inventaire.getEnergies().add(energy)  ;
    }

    @Override
    public Boolean wouldActivateCard(ArrayList<Card> cards, int stars) {
        return true;
    }

    @Override
    public Card ActivateACard(ArrayList<Card> cards, int stars) {
        if (cards.size() != 0) { // le joueur a des cartes
            return cards.get(0);
        }
        return null;
    }
}
