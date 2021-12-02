package seasons.des;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import seasons.cards.Card;
import seasons.des.faces.face;
import seasons.game.Energy;
import seasons.inventaire.Inventaire;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public  class tools {
    public  boolean canInvokeCard(Card c, Inventaire i){
        return i.getEnergies().containsAll(c.getInvocationCost())&&i.getCristos()>=c.getCristalCost();
    }
    public static int EnergyACrystaliserToCristaux(Energy e, int saison) {

        int crystauxAAjouter = 0;

            switch (saison) {
                case 0:
                    if (e == Energy.WIND || e == Energy.WATER)
                        crystauxAAjouter += 1;
                    else if (e == Energy.FIRE)
                        crystauxAAjouter += 2;
                    else
                        crystauxAAjouter += 3;
                    break;
                case 1:
                    if (e == Energy.EARTH || e == Energy.WATER)
                        crystauxAAjouter += 1;
                    else if (e == Energy.WIND)
                        crystauxAAjouter += 2;
                    else
                        crystauxAAjouter += 3;
                    break;
                case 2:
                    if (e == Energy.EARTH || e == Energy.FIRE)
                        crystauxAAjouter += 1;
                    else if (e == Energy.WATER)
                        crystauxAAjouter += 2;
                    else
                        crystauxAAjouter += 3;
                    break;
                default:
                    if (e == Energy.WIND || e == Energy.FIRE)
                        crystauxAAjouter += 1;
                    else if (e == Energy.EARTH)
                        crystauxAAjouter += 2;
                    else
                        crystauxAAjouter += 3;
                    break;
            }

        return crystauxAAjouter;
    }


    public static des[] getDes(String couleur){
        des[] des= new des[5] ;


        JSONParser jsonP = new JSONParser();
        try{
            JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader("Ressources/Des.json"));
            JSONObject desJson = (JSONObject) jsonO.get(couleur);

            for (int i=1;i<6;i++){
                 face[] faces= new face[6];
                JSONObject desT = (JSONObject)desJson.get(i+"");

                for(int j=0;j<6;j++){
                    JSONObject facesJson = (JSONObject) desT.get("faces");
                    JSONObject faceJson=(JSONObject)facesJson.get("6");
                    int cristos=((Number)faceJson.get("points")).intValue();
                    int mois= ((Number)faceJson.get("moves")).intValue();
                    boolean stars = (boolean)faceJson.get("star");
                    int[] energies=new int[4];
                    JSONArray colArray=(JSONArray)faceJson.get("energies");
                    for(int f=0; f<colArray.size();f++){
                        energies[f]=((Number)colArray.get(f)).intValue();
                    }

                    //
                    boolean grind=(boolean)(faceJson.get("grind"));
                    boolean cristalisation =(boolean)(faceJson.get("crystallisation"));


                    faces[j]= new face(cristos,mois,stars,energies,cristalisation,grind);
                }
                des[i-1]=(new des(faces,couleur));
            }

            // System.out.println("dice :"+ face.get("1"));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return des;
    }

}
