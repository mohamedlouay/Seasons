package seasons.screen;

import seasons.cards.Card;
import seasons.des.faces.face;
import seasons.inventaire.Inventaire;
import seasons.player.Player;

import java.util.ArrayList;
import java.util.Collections;

/**
 * la classe Display permet d'afficher les statistiques du jeu pendant ces diffrentes phases
 * -debut du jeu
 * pendant le round ( les dés et les cartes choisis par les joueurs , les cristaux gagnés ...
 * le resultat final
 */

public class Display {

    Mode mode;

    public Display(Mode mode) {
        this.mode = mode;

    }

    public void DisplayMessage(String message) {
        if (mode == Mode.EXTEND)
            System.out.println(message);


    }


    public void welcomeMessage() {
        if (mode == Mode.EXTEND)  {
            System.out.println("================SEASONS================");

        }

    }


    /**
     * pour cette itération ,on affiche juste le numero de tour actuel
     * -on va ajouter statistique de chaque joueur (nombre de points de prestiges , nombre d'energies,
     * nombre de cartes qu'il a joué ....
     */
    public void roundLog(int round) {
        if (mode == Mode.EXTEND) {
            System.out.println();
            System.out.println("           round : " + round + "");
            System.out.println();

        }

    }


    public void printStatsRound(int round, int mois, ArrayList<Inventaire> inventaires, ArrayList<face> faces) {

        if (mode == Mode.EXTEND) {
            System.out.println("-------------------------------------");
            System.out.println("         ROUND : " + round + "     ");
            System.out.println("-------------------------------------");


            System.out.println("Annee : " + (int) (mois / 12) + " | mois : " + mois % 12 + "| season :" + ((mois % 12) / (3)));
            System.out.println("-------------------------------------");
            for (Inventaire i : inventaires) {
                System.out.println("le joueur <" + i.getPlayer().getName() + "> a " + i.getCristos() + " cristaux  et " + i.getStars() + " Stars");
                System.out.println("Energies: " + (!(i.getEnergies() == null) ? i.getEnergies().toString() : "") + " ");
                System.out.println(i.getPlayer().printCards());
                System.out.println(i.printInvokedCards());

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
    }

    public void gainFromDice(Player player, int nbEnergy, int nbPrestige) {

        if (mode == Mode.EXTEND) {

            System.out.println(player.getName() + " a gagné : " + nbEnergy + " energies " + nbPrestige + " points de prestiges ");

        }

    }


    public void gainFromCard(Player player, Card card) {

        if (mode == Mode.EXTEND) {
            System.out.println("le joueur " + player.getName() + " a invoqué la carte " + card.getCardName());
            System.out.println("contre " + card.getInvocationCost() + " et " + card.getCristalCost() + "  crystaux ");
        }
    }


    public void winner(ArrayList<Inventaire> inventaires) {

        if ((mode == Mode.EXTEND) || (mode == Mode.RECAP)) {

            System.out.println();
            System.out.println();
            System.out.println("------------------FIN DE LA PARTIE----------------");


            for (Inventaire i : inventaires) {

                System.out.println("Player : " + i.getPlayer().getName() + " | NBR CRYSTOS : " + i.getCristos());

            }
        }

    }


    public void displayStatistics(ArrayList<Player> players, int[] moyCrystals,
                                  int[] pickedCards, int[] invockedCards,
                                  int[] jauge) {





        if (mode == Mode.EXTEND) {
            System.out.println();
            System.out.println();
            System.out.println("------------------FIN DE LA PARTIE----------------");



            // afficher les noms de joueurs
            System.out.print("joueurs            : ");
            for (Player p :players) {
                System.out.print(p.getName() + "   |   ");

            }
            System.out.println();

            // affichers avg points cristaux
            System.out.print("points cristaux    : ");
            for (Integer p :moyCrystals) {
                System.out.print(p + "   |   ");

            }
            System.out.println();

            // affichers avg cartes piochées
            System.out.print("cartes piochées    : ");
            for (Integer p :pickedCards) {
                System.out.print(p + "   |   ");

            }
            System.out.println();

            // affichers avg cartes invoquées
            System.out.print("cartes invoquées   : ");
            for (Integer p :invockedCards) {
                System.out.print(p + "   |   ");

            }
            System.out.println();

            // affichers avg jauge d'invocation finale
            System.out.print("jauge d'invocation : ");
            for (Integer p :jauge) {
                System.out.print(p + "   |   ");

            }
            System.out.println();

        }


    }

    public void displayStatisticsMulti(double nb , ArrayList<Player> players, int[] moyCrystals, int[] pickedCards, int[] invockedCards, int[] jauge) {




        if  (mode == Mode.RECAP) {
            System.out.println("=======================SEASONS====================");
            System.out.println();
            System.out.println("-----------------AVERAGE 1000 PARTIES -------------");



            // afficher les noms de joueurs
            System.out.print("joueurs            : ");
            for (Player p :players) {
                System.out.print(p.getName() + "   |   ");

            }
            System.out.println();

            // affichers avg points cristaux
            System.out.print("points cristaux    : ");
            for (Integer p :moyCrystals) {
                System.out.print(p /nb + "   |   ");

            }
            System.out.println();

            // affichers avg cartes piochées
            System.out.print("cartes piochées    : ");
            for (Integer p :pickedCards) {
                System.out.print(p/nb + "   |   ");

            }
            System.out.println();

            // affichers avg cartes invoquées
            System.out.print("cartes invoquées   : ");
            for (Integer p :invockedCards) {
                System.out.print(p / nb+ "   |   ");

            }
            System.out.println();

            // affichers avg jauge d'invocation finale
            System.out.print("jauge d'invocation : ");
            for (Integer p :jauge) {
                System.out.print(p/nb + "   |   ");

            }


        }




    }
}