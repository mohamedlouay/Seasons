package seasons.cards;


import seasons.cards.effets.Effect;
//import seasons.cards.effets.Effect_Activation_Mode;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.cards.effets.EmptyEffect;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class Card extends ArrayList<Card> {
    int cardNumber ;
    String cardName ;
    int prestigePoint ;
    Type type;
    ArrayList<Energy> invocationCost;
    int cristalCost;
    Effect effect;
    Effect_Activation_Mode activation ;

    public Effect_Activation_Mode getActivation() {
        return activation;
    }

   /* public void setActivation(Effect_Activation_Mode i){
        this.activation=i;
    }*/


    public Card(int cardNumber , Type type, String cardName, int prestigePoint, ArrayList AvocationCost, int cristalCost,Effect_Activation_Mode activation) {
        this.cardNumber = cardNumber;
        this.cardName=cardName;
        this.prestigePoint = prestigePoint;
        this.invocationCost= AvocationCost;
        this.cristalCost = cristalCost;
        this.type=type;
        this.effect= new EmptyEffect();
        this.activation = activation;


    }

    public Type getType() {
        return type;
    }

    public int getCardNumber() {
        return cardNumber;
    }


    public String getCardName() {
        return cardName;
    }
    public Effect getEffect() {
        return effect;
    }



    public int getPrestigePoint() {
        return prestigePoint;
    }

    public ArrayList<Energy> getInvocationCost() {
        return invocationCost;
    }


    public int getCristalCost() {
        return cristalCost;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
    public void excuteCardEffect(Inventaire i, Game g){
        this.effect.excute(i,g);
    }


}