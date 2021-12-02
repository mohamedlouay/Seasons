package seasons.cards.effets;

import org.junit.jupiter.api.Test;
import seasons.game.Energy;

import static org.junit.jupiter.api.Assertions.*;

class Effect_Activation_ModeTest {

    @Test
    public void Effet_Activation_Mode_Value_Test(){
        Effect_Activation_Mode EffetMode = Effect_Activation_Mode.AT_PLAY;
        assertEquals(Effect_Activation_Mode.valueOf("AT_PLAY"), EffetMode);

    }

}