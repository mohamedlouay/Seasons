package seasons.inventaire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import seasons.cards.Card;
import seasons.cards.Type;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.game.Game;
import seasons.player.IAStrategy;
import seasons.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventaireTest {
    Player player;
    Inventaire inventaire;
    Card card = Mockito.mock(Card.class);
    Game game = Mockito.mock(Game.class);
    face f;
    ArrayList<Energy> energy1;
    Effect_Activation_Mode i;
    Observable o;



    @BeforeEach
    void setUp() {
        player = new Player("player1", new IAStrategy());
        inventaire = new Inventaire(player, game);
        ArrayList<Energy> energies = new ArrayList<>(Arrays.asList(Energy.FIRE, Energy.FIRE));
        inventaire.setEnergies(energies);
        inventaire.addCrystals(6);
        inventaire.addAvocation(2);
        inventaire.setDesActuel(f);
        inventaire.addPickedCard();
        inventaire.activatedCards=new ArrayList<>();



    }


    @Test
    void verifEnegiesEgal() {


        // cas 1 : le cout d invocation est egale a l'energies dans l'inventaire
        //test if the energies of the inventory have been decreased

        int oldSize = inventaire.getEnergies().size();
        ArrayList<Energy> energiesCard = new ArrayList<Energy>(Arrays.asList(Energy.FIRE, Energy.FIRE));
        when(card.getInvocationCost()).thenReturn(energiesCard);
        assertTrue(inventaire.verifEnegies(card));
        assertEquals(oldSize - energiesCard.size(), inventaire.getEnergies().size());

        setUp();


        // cas 2 : le cout d invocation est inferieur a l'energies dans l'inventaire


        energiesCard = new ArrayList<Energy>(Arrays.asList(Energy.FIRE));
        when(card.getInvocationCost()).thenReturn(energiesCard);
        assertTrue(inventaire.verifEnegies(card));
        setUp();


        // cas 3 : le cout d invocation est superieur a l'energies dans l'inventaire
        //test if the energies of the inventory have been decreased

        oldSize = inventaire.getEnergies().size();
        energiesCard = new ArrayList<Energy>(Arrays.asList(Energy.FIRE, Energy.FIRE, Energy.FIRE, Energy.FIRE));
        when(card.getInvocationCost()).thenReturn(energiesCard);
        assertFalse(inventaire.verifEnegies(card));
        assertEquals(oldSize, inventaire.getEnergies().size());
        setUp();


        // cas 4 : le cout d invocation est zero


        energiesCard = new ArrayList<Energy>();
        when(card.getInvocationCost()).thenReturn(energiesCard);
        assertTrue(inventaire.verifEnegies(card));
        verify(card, times(4)).getInvocationCost();


    }

    @Test
    void getCristos() {
        assertEquals(6, inventaire.getCristos());
    }

    @Test
    void getStars() {
        assertEquals(2, inventaire.getStars());

    }

    @Test
    void getPlayer() {
        assertEquals(player, inventaire.getPlayer());

    }

    @Test
    void getFaceObtenue() {

        assertEquals(f, inventaire.getFaceObtenue());

    }

    @Test
    void getPickedCards() {
        assertEquals(1, inventaire.getPickedCards());

    }

    @Test
    void getSeason() {
        assertEquals(0, inventaire.getSeason());

    }

    @Test
    void getMaxEnergies() {
        assertEquals(inventaire.maxEnergies, inventaire.getMaxEnergies());
    }

    @Test
    void getInvokedcards() {

        assertEquals(inventaire.invokedCards, inventaire.getInvokedcards());
    }

    @Test
    void listOfInvokedCards() {
        assertEquals(inventaire.invokedCards, inventaire.listOfInvokedCards());

    }

    @Test
    void invokeACard() {
        inventaire.invokeACard(card);
        ArrayList<Card> c = new ArrayList<>();
        c.add(card);


        assertEquals(c, inventaire.invokedCards);
    }

    @Test
    void subtractCrystals()  {
        inventaire.subtractCrystals(1);
        assertEquals(5, inventaire.getCristos());

    }

    @Test
    void AddTreeTimesCrystals() {
        inventaire.AddTreeTimesCrystals();
        assertEquals(12, inventaire.getCristos());
    }

    @Test
    void addPickedCard() {
        inventaire.addPickedCard();
        assertEquals(2, inventaire.getPickedCards());
    }

    @Test
    void activateACard() {
        inventaire.activateACard(card);
        ArrayList<Card> c = new ArrayList<>();
        c.add(card);
        assertEquals(c, inventaire.activatedCards);
    }
    @Test
    void setActivation(){
        inventaire.setActivation(i);
        assertEquals(i, inventaire.activation);
    }



    @Test
    void printInvokedCards() {
        inventaire.invokedCards.add(card);
       assertEquals("## Invoked CARDS## >> " + card.getCardName() + " | ",inventaire.printInvokedCards());
    }




}















