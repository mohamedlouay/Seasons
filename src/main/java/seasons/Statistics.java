package seasons;

import seasons.player.Player;
import seasons.player.PlayerStrategy;
import seasons.screen.Display;

import java.util.ArrayList;

public  class Statistics {

    int[] moyCrystals ;
    int[] pickedCards ;
    int[] invockedCards ;
    int[] jauge   ;
    Display display ;
    public Statistics(Display display, int nbPlayers) {
        this.display=display;
         moyCrystals = new int[nbPlayers] ;
         pickedCards =new int[nbPlayers] ;
         invockedCards =  new int[nbPlayers] ;
         jauge   = new int[nbPlayers] ;
    }


    public void staticOneGame(ArrayList<Player> players )
    {


        for (int k = 0; k <players.size() ; k++) {



            moyCrystals[k]= players.get(k).getInventaire().getCristos();
            pickedCards[k]= players.get(k).getInventaire().getPickedCards();
            invockedCards[k]=players.get(k).getInventaire().getInvokedcards().size();
            jauge[k]=players.get(k).getInventaire().getStars();

        }


        display.displayStatistics(players,moyCrystals,pickedCards,invockedCards,jauge);


    }


    public void staticMultiGame(ArrayList<Player> players) {


        for (int k = 0; k <players.size() ; k++) {



            moyCrystals[k]+=players.get(k).getInventaire().getCristos();
            pickedCards[k]+=players.get(k).getInventaire().getPickedCards();
            invockedCards[k]+=players.get(k).getInventaire().getInvokedcards().size();
            jauge[k]+=players.get(k).getInventaire().getStars();

        }







    }

    public void printStaticMultiGame(int nb ,ArrayList<Player> players) {
        display.displayStatisticsMulti(nb,players,moyCrystals,pickedCards,invockedCards,jauge);

    }


}
