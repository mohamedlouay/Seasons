package seasons.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seasons.cards.effets.Effect;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card;
    int cardNumber = 1;
    String cardName = "Amulette de fer";
    int prestigePoint = 6;
    Type type = Type.FAMILIERS;
    ArrayList<Energy> AvocationCost = new ArrayList<Energy>(Arrays.asList(Energy.FIRE, Energy.FIRE, Energy.FIRE));
    int cristalCost = 3;
    Effect_Activation_Mode activationMode = Effect_Activation_Mode.AT_PLAY;
    Effect effect;
    Game g;
    Inventaire i;


    @BeforeEach
    void init() {
        card = new Card(cardNumber, type, cardName, prestigePoint, AvocationCost, cristalCost, activationMode);
    }


    @Test
    void getType()  {
        assertEquals(Type.FAMILIERS, card.getType());
    }

    @Test
    void getCardNumber() {
        assertEquals(1, card.getCardNumber());
    }

    @Test
    void getPrestigePoint() {

        assertEquals(6, card.getPrestigePoint());
    }

    @Test
    void getAvocationCost() {

        assertEquals(Arrays.asList(Energy.FIRE, Energy.FIRE, Energy.FIRE), card.getInvocationCost());
    }

    @Test
    void getCristalCost() {

        assertEquals(3, card.getCristalCost());
    }

    @Test
    void getCardName() {
        assertEquals("Amulette de fer", card.getCardName());
    }





}


