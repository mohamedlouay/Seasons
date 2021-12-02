package seasons.des;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import seasons.des.faces.face;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
@ExtendWith(MockitoExtension.class)
class desTest {

    @Mock
    Random rand;
    des desTest;

    @BeforeEach
    void setUp() {
        String couleur = "blue";
        desTest = tools.getDes(couleur)[0];
        desTest.setRandom(rand);
    }

    @Test
    //on test si la face obtenue est bien inclus dans le Des ;
    void getRandomFace() {

        when(rand.nextInt(anyInt())).thenReturn(2);
        assertTrue(desTest.getRandomFace().getCristos()==0);

    }

    private  boolean checkContain(face[] faces,face face){
        for (face f:faces)if (f==face)return true;
        return false;

    }

}