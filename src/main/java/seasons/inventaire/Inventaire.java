package seasons.inventaire;

import seasons.cards.Card;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.player.Player;

import java.util.ArrayList;
import java.util.List;


///
public class Inventaire implements Observateur {
    int saison = 0;
    private face faceObtenue;
    private int cristos;
    private Player p;
    public int stars;
    int maxEnergies = 7 ;
    public int energyNumber;
    int pickedCards = 0 ;

    List<Card> InvokedCards = new ArrayList<Card>();

    Effect_Activation_Mode activation;
    ArrayList<Energy> energies;
    ArrayList<Card> invokedCards;
    ArrayList<Card> activatedCards;



    Game g;


    public Inventaire(Player p, Game g) {
        energies = new ArrayList<Energy>();
        invokedCards = new ArrayList<Card>();


        this.p = p;
        this.g = g;
    }

    public void setDesActuel(face f) {
        this.faceObtenue = f;
    }

    public int getCristos() {
        return cristos;
    }

    public int getStars() {
        return stars;
    }

    public ArrayList<Energy> getEnergies() {
        return energies;
    }

    public void setEnergies(ArrayList<Energy> energies) {
        this.energies = energies;
    }


    public Player getPlayer() {
        return this.p;
    }

    public void update() {
        for (Energy e : this.faceObtenue.getEnergies()) {

            //nombre maximum d'energies atteint
            if(this.getEnergies().size()==maxEnergies)
            {
                this.getPlayer().switchEnergy(this,e) ;
            }
            else
            {
                energies.add(e);
            }


        }

        this.stars += this.faceObtenue.getStars();
    }


    @Override
    public void actualiser(Observable o) {
        this.saison = ((Game) o).getSeason();
    }


    public face getFaceObtenue() {
        return faceObtenue;
    }


    public ArrayList<Card> getInvokedcards() {
        return this.invokedCards;
    }

    public ArrayList<Card> listOfInvokedCards() {

        return (ArrayList<Card>) this.InvokedCards;
    }

    public int getSeason() {
        return this.saison;
    }



    public void setActivation(Effect_Activation_Mode i){
        this.activation=i;
    }





    public void invokeACard(Card c) {
        this.invokedCards.add(c);
    }//

    public String printInvokedCards() {
        String result = "## Invoked CARDS## >> ";
        for (Card c : invokedCards) {
            result += c.getCardName() + " | ";
        }
        return result;
    }




    public void addCrystals(int n) {
        this.cristos += n;
    }
    public void subtractCrystals(int n) {
        this.cristos -= n;
    }

    public void addAvocation(int n) {
        this.stars += n;
    }




    public void AddTreeTimesCrystals() { this.cristos+= 6;    }




    public Boolean verifEnegies(Card CardToPlay) {


        ArrayList<Energy> energiesCard = CardToPlay.getInvocationCost();
        ArrayList<Energy> tmp = new ArrayList<>(this.getEnergies());
        Boolean find = true;

        for (Energy e : energiesCard) {
            if (tmp.contains(e)) {
                tmp.remove(e);

            } else {
                find = false;
            }
        }

        if (find == true) {
            this.setEnergies(new ArrayList<>(tmp));
        }

        return find ;



    }

    public int getMaxEnergies() {
        return maxEnergies;
    }

    public void setMaxEnergies(int maxEnergies) {
        this.maxEnergies = maxEnergies;
    }

    public void activateACard(Card cardToActivate) {this.activatedCards.add(cardToActivate);

    }


    public int getPickedCards() {
        return pickedCards;
    }

    public void setPickedCards(int pickedCards) {
        this.pickedCards = pickedCards;
    }
    public void addPickedCard() {
        this.pickedCards += 1;
    }
}

