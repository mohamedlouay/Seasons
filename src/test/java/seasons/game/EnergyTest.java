package seasons.game;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {



    public ArrayList<String> enumIteration() {
        Energy[] energys = Energy.values();
        ArrayList<String> stringEnergy = new ArrayList<String>();
        for (Energy energy : energys) {
            stringEnergy.add(energy.toString());
        }
        return stringEnergy;
    } //The static values() method of the java.lang.Enum class that all enums
     // inherit gives you an array of enum values.

    @Before
    public void setUp() {
        EnergyTest enumIteration = new EnergyTest();
    }


    @After
    public void tearDown() {
        EnergyTest enumIteration = null;
    }

    @Test
    public void EnergyValueTest(){
        Energy energy = Energy.WIND;
        assertEquals(energy.valueOf("WIND"), energy);

    }
     //The test code assigns a value to the day variable of the enum type,Enenuergy.
    // In this case, it is set to WIND. The test code then asserts the value.

    @Test

    public void enumIterationTest() {
        EnergyTest enumIteration = new EnergyTest();
        ArrayList<String> result = enumIteration.enumIteration();
        Iterator iterator = result.iterator();
        iterator.hasNext();
        assertTrue(result.contains("WATER"));
    }


}