package seasons.player;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import seasons.des.faces.face;
import seasons.inventaire.Inventaire;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomStrategyTest {
    @Mock
    Random r;

    Player p;
    Inventaire i ;
    ArrayList<face> faces;
    face returnedFace;
    RandomStrategy rst;

    @Given("a player of name {string} ")
    public void APlayerOfName(String name){
        rst=new RandomStrategy();
        rst.setRandom(r);
        p=new Player("ahmed",rst);

    }
    @And("liste of dices ")
    public void ListOfDices(){
        faces=new ArrayList<>();
        faces.add(new face(0,0,false, new int[]{0,0,0,0},false,false));
        faces.add(new face(1,2,false, new int[]{0,0,0,0},false,false));
    }

    @When("player choose dice")
    public void PlayerChooseDice(){
        when(r.nextInt(anyInt())).thenReturn(0);
        returnedFace=p.choisirUndes(faces,i);
    }
    @Then("dices contain returned face")
    public void DicesContainReturnedFace(){
        assertTrue(faces.contains(returnedFace));

    }
    //psk mock de random renvois 0
    @And("returned face is the first one of Dice list")
    public void returnedFaceIsTheFirstOneOfDiceList(){
        assertEquals(returnedFace,faces.get(0));
    }
    @And("returned face has {int} crystaux And {int} mois")
    public void returnedFaceHaseZeroCrys(){
        assertEquals(0,returnedFace.getCristos());
    }



    @Test
    void choisirUndes() {
        APlayerOfName("name");
        ListOfDices();
        PlayerChooseDice();
        DicesContainReturnedFace();
        returnedFaceIsTheFirstOneOfDiceList();
    }
}