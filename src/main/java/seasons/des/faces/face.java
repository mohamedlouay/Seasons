package seasons.des.faces;

import seasons.game.Energy;

import java.util.ArrayList;
import java.util.Random;

public  class face {
    int cristos;
    int mois;
    int stars;

    public boolean isGrind() {
        return grind;
    }

    public boolean grind;

    public boolean isCristalisation() {
        return cristalisation;
    }

    private boolean cristalisation;
    ArrayList<Energy> energies;


    public int getStars() {
        return stars;
    }

    public face(int cristos,int mois,boolean starsboolean,int[] energiesList,boolean cristalisation,boolean grind){
        this.cristos=cristos;
        this.mois=mois;
        this.stars=starsboolean?1:0;
        this.cristalisation=cristalisation;
        this.grind=grind;
        energies= new ArrayList<Energy>();
        //ajouter une energie aleatoire pour tester l implemenation des energies
        //pour water
       for(int i=0;i<energiesList[0];i++){
           energies.add(Energy.WATER);
       }
        //pour fire
        for(int i=0;i<energiesList[1];i++){
            energies.add(Energy.FIRE);
        }
        //pour ground
        for(int i=0;i<energiesList[2];i++){
            energies.add(Energy.EARTH);
        }
        //pour wind
        for(int i=0;i<energiesList[3];i++){
            energies.add(Energy.WIND);
        }


    }
    public ArrayList<Energy> getEnergies(){
        return this.energies;
    }

    public int getCristos() {
        return cristos;
    }

    public int getMois() {
        return mois;
    }
    public String print_face(String color){
        String result="";
        result+=energies.size()!=0?" "+energies.toString():"";
        result+=cristos!=0?" crystaux : "+this.cristos:"";
        result+=this.mois!=0?" points : "+this.mois:"";
        result+=this.grind?" <pioche>  ":"";
        result+=this.cristalisation?" <crystalisation> ":"";
        result+=this.stars!=0?" <STAR> ":"";

        return "<< "+result+" >>";
    }
}
