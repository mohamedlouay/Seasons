package seasons.game;

import seasons.cards.Card;
import seasons.cards.CardFactory;
import seasons.cards.effets.Effect_Activation_Mode;
import seasons.des.des;
import seasons.des.faces.face;
import seasons.des.tools;
import seasons.inventaire.Inventaire;
import seasons.inventaire.Observable;
import seasons.inventaire.Observateur;
import seasons.player.Player;
import seasons.screen.Display;

import java.util.ArrayList;
import java.util.Collections;

public class Game implements Observable {
    Display display;
    int round;
    int mois;
    ArrayList<Player> players;
    des[] ListDesdesB;
    des[] ListDesdesR;
    des[] ListDesdesJ;
    des[] ListDesdesV;
    des[] des;
    ArrayList<Inventaire> inventaires;
    ArrayList<face> facesVisiblesDesDes;
    ArrayList<Card> allcards;
    ArrayList<Card> discardPile = new ArrayList<>(); // la defausse !!

    public Game(ArrayList<Player> players, Display display) {
        round = 1;
        mois = 0;
        this.display = display;
        this.players = players;
        allcards = CardFactory.createCards();
        createDices();
        createInventaires();
        DistribuerlesCartes();
        display.welcomeMessage();
    }



    private void createDices() {

        this.ListDesdesB = tools.getDes("blue");
        this.ListDesdesR = tools.getDes("rouge");
        this.ListDesdesJ = tools.getDes("jaune");
        this.ListDesdesV = tools.getDes("vert");
        des = ListDesdesB;

        facesVisiblesDesDes = new ArrayList<face>();


    }


    private void createInventaires() {
        this.inventaires = new ArrayList<Inventaire>();
        for (Player p : this.players) {
            Inventaire i = new Inventaire(p, this);
            inventaires.add(i);
            p.setInventaire(i);
        }
    }

    private void DistribuerlesCartes() {

        for (int i = 0; i < 9; i++) {
            for (Player p : players) {
                p.getCards().add(allcards.get(allcards.size() - 1));
                allcards.remove(allcards.size() - 1);
            }
        }
    }


    public void play() {
        display.printStatsRound(round, this.mois, inventaires, facesVisiblesDesDes);

        while (this.mois < 36) {
            round();
            swapPlayers();
        }

        //calculer les cristaux gagnés en calculant les points de prestige marqués sur les cartes jouées
        calculateCards();
    }


    protected void round() {
        update_invokedCardMonthly();
        jouerLesDes();

        //chaque joueur choisi un des
        choixDesDes();

        for (Inventaire i : inventaires) {

            DiceActions(i);
            i.update();
            PlayCards(i);


        }
        updateMonth();

        updateAllCards();
        this.notifierObservateurs();
        this.round++;
        display.printStatsRound(round, this.mois, inventaires, facesVisiblesDesDes);

    }


    /***
     * Les actions suivantes des dés des saisons, doivent toujours être résolues
     * avant d’effectuer toute autre action :
     * piocher une carte, recevoir des énergies, recevoir des cristaux, augmenter sa jauge d’invocation.
     * @param i
     */
    protected void DiceActions(Inventaire i) {


        // si le joueur a le dés qui permet de piocher :
        if (i.getFaceObtenue().isGrind()) {
            drawAcard(i);
        }

        // si le joueur a le dés qui permet de cristalliser et le joueur veux cristalliser  :
        if ((i.getFaceObtenue().isCristalisation()) && (i.getPlayer().veutCystaliser(i, this.getSeason()))) {
            crystaliser(i);
        }
    }

    public void update_invokedCardMonthly() {
        for (Inventaire i : inventaires) {
            for (Card c : i.getInvokedcards()) {
                if (c.getActivation() == Effect_Activation_Mode.AT_PLAY) {
                    //  i.getCorbeilleCards().add(c);
                }
            }
            // i.getInvokedcards().removeAll(i.getCorbeilleCards());
        }
    }


    public void drawAcard(Inventaire i) {
        Card c = allcards.get(allcards.size() - 1);

        //voir si le joueur veux garder la carte ou non
        if (i.getPlayer().keepTheCard(this.mois)) {
            i.getPlayer().addCard(c);
            i.addPickedCard();
        } else {
            discardPile.add(c);
        }
        allcards.remove(c);
        //on excute les effets qui se declanche en on pioche
        for (Card card : i.getInvokedcards()) {
            card.getEffect().onEndOfYear(i, this);
        }

    }


    public void crystaliser(Inventaire i) {
        int compteurCrystaux = 0;


        ArrayList<Energy> ec = i.getPlayer().getEnergiesACrystaliser(i, this.getSeason());
        for (Energy e : ec) {
            compteurCrystaux += tools.EnergyACrystaliserToCristaux(e, this.getSeason());
            display.DisplayMessage(">>player " + i.getPlayer().getName() + " " +
                    "a crystalisé : " + e + " contre : " + tools.EnergyACrystaliserToCristaux(
                    e, this.getSeason()) + " Crystaux");
        }

        i.getEnergies().removeAll(ec);


        i.addCrystals(compteurCrystaux);
        for (Card card : i.getInvokedcards()) {
            card.getEffect().onCrystalise(i, this);
        }

    }


    public void update_invokedCard() {
        for (Inventaire i : inventaires) {
            for (Card c : i.getInvokedcards()) {
                if (c.getActivation() == Effect_Activation_Mode.AT_PLAY) {
                    //  i.getCorbeilleCards().add(c);
                }
            }
            // i.getInvokedcards().removeAll(i.getCorbeilleCards());
        }
    }


    protected void PlayCards(Inventaire i) {

        Boolean answer = i.getPlayer().wouldPlayCard();
        while (answer) // le joueur veux jouer une carte
        {
            Card CardToPlay = i.getPlayer().carteAJouer(this.mois);
            int jauge = i.getStars() - i.getInvokedcards().size();

            if (!(CardToPlay == null) && (jauge >= 1)) {
                Boolean find;
                find = verifEnergies(i, CardToPlay);
                if (find == true) {
                    i.invokeACard(CardToPlay);
                    //excuter l effet de la carte
                    CardToPlay.getEffect().excute(i, this);
                    //remove card from playr hand
                    i.getPlayer().getCards().remove(CardToPlay);
                    display.gainFromCard(i.getPlayer(), CardToPlay);
                    // appliquer les effets des cartes invoqués lorque on invoque une nouvelle carte
                    for (Card card : i.getInvokedcards()) {
                        card.getEffect().onSeasonChange(i, this);
                    }
                }

            }
            //si le joueur veux jouer une carte encore
            answer = i.getPlayer().wouldPlayCardAgain();

        }


    }

    public void ActivateCard(Inventaire i) {
        Boolean answer = i.getPlayer().wouldActivateCard();
        if (answer) // le joueur veux jouer une carte
        {
            Card CardToActivate = i.getPlayer().carteToActivate();
            int jauge = i.getStars() - i.getInvokedcards().size();

            if (!(CardToActivate == null) && (jauge >= 1)) {
                Boolean find;
                find = verifEnergies(i, CardToActivate);
                if (find == true) {
                    i.activateACard(CardToActivate);
                    //excuter l effet de la carte
                    CardToActivate.getEffect().onActivate(i, this);
                    //remove card from playr hand
                    i.getPlayer().getCards().remove(CardToActivate);
                    display.gainFromCard(i.getPlayer(), CardToActivate);
                    // appliquer les effets des cartes invoqués lorque on invoque une nouvelle carte
                    for (Card card : i.getInvokedcards()) {
                        card.getEffect().onSeasonChange(i, this);
                    }
                }


            }
        }
    }


    protected Boolean verifEnergies(Inventaire i, Card CardToPlay) {
        Boolean find;
        find = i.verifEnegies(CardToPlay);
        return find;


    }


    private void jouerLesDes() {
        facesVisiblesDesDes = new ArrayList<face>();

        //on jete les n+1 Des , et on construit une list de n+1 faces
        for (int i = 0; i < inventaires.size() + 1; i++) {
            facesVisiblesDesDes.add(des[i].getRandomFace());
        }
        //afficher les DES
        for (face f : facesVisiblesDesDes) {
            display.DisplayMessage(f.print_face(""));
        }
    }

    //choix des dés :
    private void choixDesDes() {

        for (Inventaire i : inventaires) {
            face face = i.getPlayer().choisirUndes(facesVisiblesDesDes, i);
            display.DisplayMessage(">> le Player" + i.getPlayer().getName() + "a choisi le des " + face.print_face(""));
            ;
            i.setDesActuel(face);
            facesVisiblesDesDes.remove(face);
        }
    }


    public void updateMonth() {
        //on lance le des restant

        int oldSeason = getSeason();

        int moisAAjouter = facesVisiblesDesDes.get(0).getMois();
        this.mois = this.mois + moisAAjouter > 36 ? 36 : this.mois + moisAAjouter;
        switch ((int) (this.mois % 12) / 3) {
            case 0:
                this.des = this.ListDesdesB;
                break;
            case 1:
                this.des = this.ListDesdesV;
                break;
            case 2:
                this.des = this.ListDesdesJ;
                break;
            default:
                des = this.ListDesdesR;
        }


        int newSeason = getSeason();

        if (oldSeason != newSeason) {
            update_invokedCardSeasonly();
        }
    }

    public void update_invokedCardSeasonly() {
        // a completer main methode update-invoked cardseasonly ligne 284
        for (Inventaire i : inventaires) {

        }
    }


    /***
     *Si à un moment donné la pioche est vide,
     *  remélangez les cartes de la défausse. Ces cartes forment la nouvelle pioche
     */
    protected void updateAllCards() {

        if (this.allcards.size() < 5) {
            Collections.shuffle(this.discardPile);
            this.allcards.addAll(this.discardPile);
            this.discardPile.clear();
        }

    }


    //calculer les cristaux gagnés en calculant les points de prestige marqués sur les cartes jouées
    protected void calculateCards() {

        for (Inventaire i : inventaires) {
            // pour chaque carte jouée ,on ajoute les des presiges marqué sur la carte
            for (Card c : i.getInvokedcards()) {

                i.addCrystals(c.getPrestigePoint());
            }

            // pour chaque carte non jouée ,le joueur perd 5 critaux
            i.addCrystals(-5 * (i.getPlayer().getCards().size()));


            // si le nombre de cristaux est negatif retourner 0

            if (i.getCristos() < 0) {
                i.addCrystals(-1 * i.getCristos());
            }


        }

    }


    /**
     * Permutation de l'ordre du premier joueur à jouer
     */
    public void swapPlayers() {

        for (int i = 0; i < players.size() - 1; i++) {
            Collections.swap(players, i, i + 1);
            Collections.swap(inventaires, i, i + 1);
        }
    }

    public int getSeason() {
        return ((this.mois % 12) / (3));
    }


    @Override
    public void ajouterObservateur(Observateur o) {

    }

    @Override
    public void supprimerObservateur(Observateur o) {

    }

    @Override
    public void notifierObservateurs() {
        for (Observateur o : inventaires) {
            o.actualiser(this);
        }

    }

    public ArrayList<Card> getAllcards() {
        return allcards;
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void AddMois(int mois) {
        if (mois < 0) {
            System.out.println("on peut pas rajouter une valeur negatif ");
            this.mois = this.mois;
        } else if (this.mois + mois > 36) {
            this.mois = 36;
        } else {
            this.mois += mois;
        }

    }
}

