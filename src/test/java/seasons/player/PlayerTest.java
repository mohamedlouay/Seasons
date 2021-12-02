package seasons.player;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seasons.cards.Card;
import seasons.cards.Type;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static seasons.game.Energy.*;

class PlayerTest {

    Game game;
    Player p;
    Card c,c1,c2;
    Inventaire inventaire ;

    @BeforeEach
    void init(){
       p=new Player("ahmed",new RandomStrategy());
        ArrayList<Energy> energy15= new ArrayList<>();
        c = new Card(15, Type.MAGIQUES, "Dé de la malice", 8,energy15,0, Effect_Activation_Mode.AT_ACTIVATION);
        c1 = null;

        c2 = new Card(15, Type.MAGIQUES, "Dé de la malice", 8,energy15,0,Effect_Activation_Mode.AT_ACTIVATION);
inventaire = new Inventaire(p,game);
       p.setInventaire(inventaire);

    }

//

    @Test
    void getName() {
        assertEquals("ahmed",p.getName());
    }


    @Test
    void addCard() {
        p.addCard(c1);
        assertTrue( p.getCards().isEmpty());
        p.addCard(c);
        assertEquals(c,p.getCards().get(0));

    }

    @Test
    void carteToActivate() {
        p.addCard(c);
        p.addCard(c2);
        inventaire.invokeACard(c);
        assertEquals(c2 , p.carteToActivate());
    }
}