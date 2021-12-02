package seasons.player;

import seasons.cards.Card;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;


public class Player {
    private PlayerStrategy strategy;
    String name;
    Inventaire i;



    ArrayList<Card> cards = new ArrayList<>();


    public Player(String name,PlayerStrategy strategy) {

        this.name = name;
        this.strategy=strategy;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setInventaire(Inventaire i) {
        this.i = i;
    }
    public Inventaire getInventaire(){
        return this.i;
    }
    public String getName() {
        return name;
    }//



    public face choisirUndes(ArrayList<face> facesVisiblesDesDes,Inventaire i ) {
        return this.strategy.choisirUndes(facesVisiblesDesDes , i);

    }
    public boolean wouldPlayCard(){
        return this.strategy.wouldPlayCard(this.getCards(),this.i);
    }

    public boolean wouldPlayCardAgain(){
        return this.strategy.wouldPlayCardAgain(this.getCards(),this.i);
    }



    public boolean veutCystaliser(Inventaire i,int saison) {
        return this.strategy.veutCystaliser(i,saison);
    }




    public Card carteAJouer(int mois){
        return this.strategy.jouerUneCarte(this.cards,mois,this.i);
    }

    public ArrayList<Energy> getEnergiesACrystaliser(Inventaire i ,int saison) {
        return this.strategy.getEnergiesACrystaliser(i.getEnergies(),saison);
    }




    public String printCards() {
        String result = "## Player CARDS## >> ";
        for (Card c : cards) {
            result += c.getCardName() + " | ";
        }
        return result;
    }

    public void addCard(Card card) {
        if(card == null){

        }else{
            this.cards.add(card);
        }
    }

    public boolean keepTheCard(int mois) {

        return this.strategy.keepTheCard(mois);

    }

    public void switchEnergy(Inventaire inventaire, Energy energy) {

        this.strategy.switchEnergy(inventaire,energy);

    }

    public Boolean wouldActivateCard() {
        return this.strategy.wouldActivateCard(this.getCards(),this.i.getStars());
    }

    public Card carteToActivate() {

        for (Card c : getInventaire().getInvokedcards()) {
            if (c.getActivation() == Effect_Activation_Mode.AT_ACTIVATION) {
                return this.strategy.ActivateACard(this.cards, this.i.getStars());
            }
        }
        return null;

    }


}



