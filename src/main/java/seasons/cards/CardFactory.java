package seasons.cards;

import seasons.cards.effets.*;
import seasons.game.Energy;

import java.util.*;

public class CardFactory {

    public static ArrayList<Card> createCards() {


        ArrayList<Card> cards = new ArrayList<>();

        // create double from every cards
        for (int i = 0; i < 2; i++) {

            ArrayList<Energy> energy1 = new ArrayList<Energy>(Arrays.asList(Energy.WIND,Energy.WIND));
            Card c1=new Card(1, Type.MAGIQUES, "Amulette d’air", 6,energy1,0,Effect_Activation_Mode.AT_PLAY);
            c1.setEffect(new AddAvocation(2));
            cards.add(c1);


            ArrayList<Energy> energy2 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.FIRE));
            cards.add(new Card(2, Type.MAGIQUES, "Amulette de feu", 6,energy2,0,Effect_Activation_Mode.AT_PLAY));

            ArrayList<Energy> energy3 = new ArrayList<Energy>(Arrays.asList(Energy.EARTH,Energy.EARTH));
            Card c3 =new Card(3, Type.MAGIQUES, "Amulette de terre", 6,energy3,0,Effect_Activation_Mode.AT_PLAY);
            c3.setEffect(new AddCrystals(9));
            cards.add(c3);

            ArrayList<Energy> energy4 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.WATER));
            Card c4 = new Card(4, Type.MAGIQUES, "Amulette d'eau", 6,energy4,0,Effect_Activation_Mode.AT_PLAY);
            c4.setEffect(new EffectCard4());
            cards.add(c4);

            // A
            ArrayList<Energy> energy5= new ArrayList<>(Arrays.asList(Energy.FIRE,Energy.FIRE,Energy.FIRE));
            Card c5 = new Card(5, Type.MAGIQUES, "Balance d'Ishtar", 4,energy5,2,Effect_Activation_Mode.AT_ACTIVATION);
            c5.setEffect(new AddTreeTimesCrystals()); //Nombre crysstals to crystalise
            cards.add(c5);


            ArrayList<Energy> energy6 = new ArrayList<Energy>(Arrays.asList(Energy.EARTH,Energy.EARTH,Energy.EARTH));
           Card c6=new Card(6, Type.MAGIQUES, "Bâton du printemps", 9,energy6,0,Effect_Activation_Mode.PERMANANT);
            c6.setEffect(new EffectCard6());
            cards.add(c6);

            ArrayList<Energy> energy7= new ArrayList<>();
            cards.add(new Card(7, Type.MAGIQUES, "Bottes temporelles", 8,energy7,0,Effect_Activation_Mode.AT_PLAY));

            ArrayList<Energy> energy8 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.WIND));
            Card c8=new Card(8, Type.MAGIQUES, "Bourse d'Io", 6,energy8,0,Effect_Activation_Mode.PERMANANT);
            c8.setEffect(new EffectCard8());
            cards.add(c8);

            ArrayList<Energy> energy9 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH,Energy.WIND,Energy.FIRE));
            Card c9 = new Card(9, Type.MAGIQUES, "Calice divin", 10,energy9,0,Effect_Activation_Mode.AT_PLAY);
            c9.setEffect(new EffectCard9());
            cards.add(c9);

            ArrayList<Energy> energy10 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.FIRE,Energy.FIRE));
            Card c10=new Card(10, Type.FAMILIERS, "Syllas le fidèle", 14,energy10,0,Effect_Activation_Mode.AT_PLAY);
            c10.setEffect(new EffectCard10());
            cards.add(c10);

            ArrayList<Energy> energy11= new ArrayList<>();
            cards.add(new Card(11, Type.FAMILIERS, "Figrim l'Avaricieux", 7,energy11,9,Effect_Activation_Mode.PERMANANT));
/*
            ArrayList<Energy> energy12= new ArrayList<>();
            Card c12 = new Card(12, Type.FAMILIERS, "Naria la prophétesse", 8,energy12,3,Effect_Activation_Mode.AT_PLAY);
            c12.setEffect(new EffectCard12());
            cards.add(c12);
            */



            ArrayList<Energy> energy13 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.FIRE));
            cards.add(new Card(13, Type.MAGIQUES, "Coffret merveilleux", 4,energy13,0,Effect_Activation_Mode.PERMANANT));

            ArrayList<Energy> energy14 = new ArrayList<Energy>(Arrays.asList(Energy.EARTH,Energy.WIND));
            cards.add(new Card(14, Type.MAGIQUES, "Corne du mendiant", 8,energy14,0,Effect_Activation_Mode.PERMANANT));

            //A
            ArrayList<Energy> energy15= new ArrayList<>();
            cards.add(new Card(15, Type.MAGIQUES, "Dé de la malice", 8,energy15,0,Effect_Activation_Mode.AT_ACTIVATION));

            ArrayList<Energy> energy16 = new ArrayList<Energy>(Arrays.asList(Energy.WIND,Energy.WIND,Energy.WIND));
            Card c16= new Card(16, Type.FAMILIERS, "Kairn le destructeur", 9,energy16,0,Effect_Activation_Mode.AT_ACTIVATION);
            c16.setEffect(new EffectCard16());
            cards.add(c16);

            ArrayList<Energy> energy17 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.WIND));
            Card c17=new Card(17, Type.FAMILIERS, "Amsug Longcoup", 8,energy17,0,Effect_Activation_Mode.AT_PLAY);
            c17.setEffect(new EffectCard17());
            cards.add(c17);

            ArrayList<Energy> energy18 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH));
            Card c18=new Card(18, Type.FAMILIERS, "Grimoire ensorcelé", 8,energy18,0,Effect_Activation_Mode.AT_PLAY);
            c18.setEffect(new EffectCard18());
            cards.add(c18);
            ArrayList<Energy> energy19 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.FIRE,Energy.FIRE));
            cards.add(new Card(19, Type.MAGIQUES, "Heaume de Ragfield", 10,energy19,0,Effect_Activation_Mode.PERMANANT));

            ArrayList<Energy> energy20 = new ArrayList<Energy>(Arrays.asList(Energy.EARTH,Energy.FIRE,Energy.WIND));
            cards.add(new Card(20, Type.MAGIQUES, "Main de la fortune", 9,energy20,3,Effect_Activation_Mode.PERMANANT));

            ArrayList<Energy> energy21 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.WIND));
            Card c21=new Card(21, Type.MAGIQUES, "Lewis Grisemine", 6,energy21,0,Effect_Activation_Mode.AT_PLAY);
            c21.setEffect(new EffectCard21());
            cards.add(c21);

            ArrayList<Energy> energy22= new ArrayList<>();
            Card c22=new Card(22, Type.MAGIQUES, "Cube runique d’Eolis", 30,energy22,20,Effect_Activation_Mode.PERMANANT) ;
            c22.setEffect(new EffectCard22());
            cards.add(c22);

            //A
            ArrayList<Energy> energy23 = new ArrayList<Energy>(Arrays.asList(Energy.FIRE,Energy.FIRE));
            Card c23 = new Card(23, Type.MAGIQUES, "Potion de puissance", 0,energy23,0,Effect_Activation_Mode.AT_ACTIVATION);
            c23.setEffect(new PowerEffect());
            cards.add(c23);

            ArrayList<Energy> energy24 = new ArrayList<Energy>(Arrays.asList(Energy.WIND,Energy.WIND));
            cards.add(new Card(24, Type.MAGIQUES, "Potion de rêves", 0,energy24,0,Effect_Activation_Mode.AT_ACTIVATION));

            ArrayList<Energy> energy25 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.WATER));
            Card c25 = new Card(25, Type.MAGIQUES, "Potion de savoir", 0,energy25,0,Effect_Activation_Mode.AT_ACTIVATION);
            c25.setEffect(new EffectCard25());
            cards.add(c25);

            ArrayList<Energy> energy26 = new ArrayList<Energy>(Arrays.asList(Energy.EARTH,Energy.EARTH));
            Card c26 = new Card(26, Type.MAGIQUES, "Potion de vie", 0,energy26,0,Effect_Activation_Mode.AT_ACTIVATION);
            c26.setEffect(new EffectCard26());
            cards.add(c26);

            ArrayList<Energy> energy27 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH,Energy.FIRE,Energy.WIND));
            Card c27 = new Card(27, Type.MAGIQUES, "Sablier du temps", 6,energy27,0,Effect_Activation_Mode.PERMANANT);
            c27.setEffect(new EffectCard27());
            cards.add(c27);
            //A
            ArrayList<Energy> energy28 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH,Energy.FIRE,Energy.WIND));
            Card c28 = new Card(28, Type.MAGIQUES, "Sceptre de grandeur", 8,energy28,0,Effect_Activation_Mode.AT_PLAY);
            c28.setEffect(new CrystaliseOfMagicObjects());
            cards.add(c28);

            ArrayList<Energy> energy29 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.WATER,Energy.WATER));
            Card c29 = new Card(29, Type.MAGIQUES, "Statue bénie d’Olaf", 0,energy29,0,Effect_Activation_Mode.AT_PLAY);
            c29.setEffect(new AddCrystals(20));
            cards.add(c29);


            ArrayList<Energy> energy30 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH,Energy.FIRE));
            Card c30=new Card(30, Type.MAGIQUES, "Vase oublié d’Yjang", 6,energy30,0,Effect_Activation_Mode.PERMANANT);
            c30.setEffect(new EffectCard30());
            cards.add(c30);



            ArrayList<Energy> energy37 = new ArrayList<Energy>(Arrays.asList(Energy.WATER,Energy.EARTH,Energy.FIRE));
            Card c37=new Card(37, Type.MAGIQUES, "Crâne de Dragon", 9,energy37,0,Effect_Activation_Mode.AT_ACTIVATION);
            c37.setEffect(new EffectCard37());
            cards.add(c37);


            ArrayList<Energy> energy40 = new ArrayList<Energy>(Arrays.asList(Energy.WIND,Energy.WIND,Energy.WIND));
            Card c40=new Card(40, Type.MAGIQUES, "Elementaire d'air", 12,energy40,0,Effect_Activation_Mode.AT_PLAY);
            c40.setEffect(new EffectCard40());
            cards.add(c40);


















        }

        // melanger les cartes
        Collections.shuffle(cards);

        return new ArrayList<>(cards);






    }


























}