package seasons.player;

import io.cucumber.java.sl.In;
import seasons.cards.Card;
import seasons.des.faces.face;
import seasons.des.tools;
import seasons.game.Energy;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IAStrategy implements PlayerStrategy {

    ArrayList<String> topEnergyProduction=new ArrayList<>();
    ArrayList<String> topPointGenerationInstantally=new ArrayList<>();
    ArrayList<String> topPointGenerationGradually=new ArrayList<>();
    ArrayList<String> topCardPicker=new ArrayList<>();


    public IAStrategy() {
        classificationOfCards();

    }

    /**
     * une classification de certaines cartes du jeu ,
     * Dans Seasons, il existe trois grandes catégories de cartes :
     * Les cartes qui produisent de l’énergie
     * celles qui produisent des points
     * et celles qui font piocher.
     */

    private void classificationOfCards() {

        //Générateurs d’énergie :

        topEnergyProduction.add("Sablier du Temps");
        topEnergyProduction.add("Vase oublié d’Yjang");
        topEnergyProduction.add("Main de la Fortune");
        topEnergyProduction.add("Couronne Vampirique");
        topEnergyProduction.add("Amulette d’Eau");
        topEnergyProduction.add("Lewis Grisemine");
        topEnergyProduction.add("Corne du mendiant");

        //Générateurs de cristaux instantanément:
        topPointGenerationInstantally.add("Cube runique d’Eolis");
        topPointGenerationInstantally.add("Heaume de Ragfield");
        topPointGenerationInstantally.add("Sceptre de Grandeur");
        topPointGenerationInstantally.add("Statue bénie d’Olaf");
        topPointGenerationInstantally.add("Potion de Vie");
        topPointGenerationInstantally.add("Amulette de Terre");

        //Générateurs de cristaux instantanément:
        topPointGenerationGradually.add("Coffret Merveilleux");
        topPointGenerationGradually.add("Arcano Sangsue");
        topPointGenerationGradually.add("Bâton du Printemps");
        topPointGenerationGradually.add("Bourse d’Io");
        topPointGenerationGradually.add("Figrim l’Avaricieux");
        topPointGenerationGradually.add("Kairn le Destructeur");
        topPointGenerationGradually.add("Balance d’Ishtar");


        //Piocheurs :

        topCardPicker.add("Calice Divin");
        topCardPicker.add("Amulette de Feu");
        topCardPicker.add("Potion de Puissance");
        topCardPicker.add("Naria la Prophétesse");


    }


    /***
     * Choisir un dé selon l'ordre d'importance dans la situation actuelle du joueur
     * @param faces
     * @return
     */


    @Override
    public face choisirUndes(ArrayList<face> faces, Inventaire i) {
        //priorité 1 : essayer d'aumenter le jauge d'invocation pour joueur des cartes des les premeirs tours
        if (i.getStars() - i.getInvokedcards().size() < 1) {
            List<face> existStar = faces.stream().filter(n -> (n.getStars()) != 0).collect(Collectors.toList());
            if (existStar.size() != 0) {
                return existStar.get(0);
            }


        }

        //priorité 2 : recuperer des energies

        if (i.getEnergies().size() < 5) {
            List<face> existEnergy = faces.stream().filter(n -> n.getEnergies().size() != 0).collect(Collectors.toList());
            if (existEnergy.size() != 0) {
                // trier les faces selon le nombre d'energies
                existEnergy.sort((o1, o2) -> String.valueOf(o1.getEnergies().size()).compareTo(String.valueOf(o2.getEnergies().size())));
                //retourner le plus grand
                return existEnergy.get(existEnergy.size() - 1);
            }


        }


        //priorité 3 : piocher une carte
        List<face> existPioche = faces.stream().filter(n -> n.isGrind()).collect(Collectors.toList());
        if (existPioche.size() != 0) {
            return existPioche.get(0);
        }


        //priorité 4 : cristalliser de energies
        List<face> existCristalisation = faces.stream().filter(n -> n.isCristalisation()).collect(Collectors.toList());
        if (existCristalisation.size() != 0) {
            return existCristalisation.get(0);
        }

        //priorité 5 : Recevoir des cristaux ou tout autre cas
        return faces.get(0);

    }

    @Override
    public boolean keepTheCard(int mois) {
        //si c'est le dernier tour defausser la carte sinon le joueur risque de perdre 5 cristaux a la fin du match
        if (mois > 34)
            return false;
        return true;
    }

    @Override
    public boolean veutCystaliser(Inventaire i, int saison) {
        // si on a une energie qui coute 2 cristaux ou plus on retourne true
        for (Energy e : i.getEnergies()) {
            if (tools.EnergyACrystaliserToCristaux(e, saison) >= 2) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<Energy> getEnergiesACrystaliser(ArrayList<Energy> energies, int saison) {

        //  retourner la liste des energies qui coutent 2 crisatux ou plus selon la saison
        ArrayList<Energy> energiesACrystaliser = new ArrayList<Energy>();
        for (Energy e : energies) {
            if (tools.EnergyACrystaliserToCristaux(e, saison) >= 2) energiesACrystaliser.add(e);
        }
        return energiesACrystaliser;
    }

    @Override
    public boolean wouldPlayCard(ArrayList<Card> cards, Inventaire i )  {
        for (Card c :cards) {
            if (verif(c,i))
            {

                return true ;
            }

        }

        return false;
    }
    public boolean wouldPlayCardAgain(ArrayList<Card> cards, Inventaire i )
    {

        return  (((i.getStars() - i.getInvokedcards().size())>0 ) && wouldPlayCard( cards, i )) ;
    }


    private boolean verif(Card CardToPlay, Inventaire i )
    {
        ArrayList<Energy> energiesCard = CardToPlay.getInvocationCost();
        ArrayList<Energy> tmp = new ArrayList<>(i.getEnergies());
        Boolean find = true;

        for (Energy e : energiesCard) {
            if (tmp.contains(e)) {
                tmp.remove(e);

            } else {
                find = false;
            }
        }
        return find ;
    }

    @Override
    public Card jouerUneCarte(ArrayList<Card> cards,int mois,Inventaire i) {

        if (cards.size() != 0) { // le joueur a des cartes
            return selectCardToPlay(cards,mois,i);
        } else
            return null;
    }

    @Override
    public void switchEnergy(Inventaire i, Energy energy) {
        //defausser l'energie la plus faible dans la réserve

        List<Energy> energiesFaible = i.getEnergies().stream().filter(
                e -> tools.EnergyACrystaliserToCristaux(e, i.getSeason()) < tools.EnergyACrystaliserToCristaux(energy, i.getSeason())).collect(Collectors.toList());

        //si il existe des energies qui ils ont un valeur plus faible que l'energie actuelle faire le switch
        if (energiesFaible.size() != 0) {
            i.getEnergies().remove(energiesFaible.get(0));
            i.getEnergies().add(energy);
        }


    }

    /***
     *  ArrayList<String> topEnergyProduction;
     *     ArrayList<String> topPointGenerationInstantally;
     *     ArrayList<String> topPointGenerationGradually;
     *     ArrayList<String> topCardPicker;
     * @param cards
     * @param mois
     * @return
     */

    public Card selectCardToPlay(ArrayList<Card> cards, int mois, Inventaire i) {


        List<Card> playerCards = cards.stream().filter(c -> verif(c,i)).collect(Collectors.toList());;



        List<Card> res ;
        //priorité 1 : Les cartes qui rapportent des points instantanément:

        if (mois > 24) {
            for (String cName : this.topPointGenerationInstantally) {

                res = playerCards.stream().filter(c -> c.getCardName().equalsIgnoreCase(cName)).collect(Collectors.toList());
                if (res.size() != 0) {

                    return res.get(0);
                }

            }
        }


        //priorité 2 : Les cartes qui rapportent des points Graduellement :

        if (mois < 24) {


            for (String cName : this.topPointGenerationGradually) {


                res = playerCards.stream().filter(c -> c.getCardName().equalsIgnoreCase(cName)).collect(Collectors.toList());
                if (res.size() != 0) {

                    return res.get(0);
                }

            }

        }

        //priorité 3 : les cartes qui rapportent de l'energie :


        for (String cName : this.topEnergyProduction) {
            res = playerCards.stream().filter(c -> c.getCardName().equalsIgnoreCase(cName)).collect(Collectors.toList());
            if (res.size() != 0) {

                return res.get(0);
            }

        }


        //priorité 4 : Les cartes qui font piocher :


        for (String cName : this.topCardPicker) {
            res = playerCards.stream().filter(c -> c.getCardName().equalsIgnoreCase(cName)).collect(Collectors.toList());
            if (res.size() != 0) {

                return res.get(0);
            }

        }


        //priorité 5 : Divers :


        return playerCards.get(0);
    }

    @Override
    public Boolean wouldActivateCard(ArrayList<Card> cards, int stars) {
        return true;
    }

    @Override
    public Card ActivateACard(ArrayList<Card> cards, int stars) {
        if (cards.size() != 0) { // le joueur a des cartes
            return cards.get(0);
        }
        return null;
    }


}
