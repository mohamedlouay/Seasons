package seasons.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import seasons.cards.Card;
import seasons.cards.Type;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.inventaire.Inventaire;
import seasons.player.IAStrategy;
import seasons.player.Player;
import seasons.player.RandomStrategy;
import seasons.screen.Display;
import seasons.screen.Mode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTest {
    Display display ;
    Game game ;
    @Mock
    Inventaire inventaireMock= Mockito.mock(Inventaire.class);


    @BeforeEach
    void initialiser() {

        display = new Display(Mode.NONE);
        //  creation des joueurs !
        ArrayList<Player> players=new ArrayList<>();

        players.add(new Player("Random", new RandomStrategy()));
        players.add(new Player("IA STRa",new IAStrategy()));
        game = new Game(players, display);

        //assurer qu'on cree des joueurs
        assertFalse(game.players.isEmpty());
        assertTrue(game.players.size() == 2);



        //assurer que les joueurs ont pioché
        for (Player p : game.players) {
            assertTrue(p.getCards().size() == 9);

        }
    }


    @Test
    void createPlayers() {

    }

    @Test
    void createCards() {
        //assurer qu'on cree des cartes
        assertFalse(game.allcards.isEmpty());
        int distributedCards = game.players.size()*9; // nombre de carte implementer
        assertEquals((62-distributedCards),game.allcards.size());
    }

    @Test
    void verifEnergies() {
        ArrayList<Energy> energy1 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.FIRE));
        Card actuelCard =new Card(1, Type.MAGIQUES, "Amulette d’air", 6,energy1,0, Effect_Activation_Mode.AT_PLAY);

        ArrayList<Energy> EnergiesPlayer = new ArrayList<>();
        EnergiesPlayer.add(Energy.FIRE);
        EnergiesPlayer.add(Energy.FIRE);
        EnergiesPlayer.add(Energy.FIRE);
        EnergiesPlayer.add(Energy.FIRE);
        EnergiesPlayer.add(Energy.FIRE);


        when(inventaireMock.verifEnegies(actuelCard)).thenReturn(true);

        assertTrue(game.verifEnergies(inventaireMock,actuelCard));
        verify(inventaireMock).verifEnegies(actuelCard);


    }


    @Test
    void getMois()  {
        assertNotNull(game.getMois());
        // debut de la partie
        assertEquals(0,game.getMois());
    }

    @Test
    void addMois() {
        game.AddMois(-1);
        assertEquals(0,game.getMois());
        game.AddMois(8);
        assertEquals(8,game.getMois());
        game.AddMois(30);
        assertEquals(36,game.getMois());

    }
}