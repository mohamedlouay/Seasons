package seasons;


import seasons.game.Game;
import seasons.player.IAStrategy;
import seasons.player.Player;
import seasons.player.RandomStrategy;
import seasons.screen.Display;
import seasons.screen.Mode;

import java.util.ArrayList;

public class Main {

    public static void main (String []args) {
        //  creation des joueurs !
        ArrayList<Player> players=new ArrayList<>();

        players.add(new Player("Joueur1(RD)", new RandomStrategy()));
        players.add(new Player("Joueur2(IA)",new IAStrategy()));
        //===========================================


        startGame(Mode.EXTEND,players);




    }

    private static void startGame(Mode mode,ArrayList<Player> players) {

        Display display = new Display(mode);// EXTEND , RECAP or NONE  for the tests
        Statistics stat = new Statistics(display,players.size());
        if((mode==Mode.EXTEND) || (mode==Mode.NONE)){
            Game game = new Game(players, display);
            game.play();
            stat.staticOneGame(players);

        }
        else if (mode==Mode.RECAP)
        {
            for (int i = 0; i < 1000; i++) {

                Game game = new Game(players, display);
                game.play();
                stat.staticMultiGame(players);



            }
            stat.printStaticMultiGame(1000,players);

        }




    }
}
