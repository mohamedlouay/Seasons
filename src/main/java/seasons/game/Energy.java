package seasons.game;

import java.util.Random;

//Energie dispo
public enum Energy {
    WIND, FIRE, WATER, EARTH;
    public static Energy getRandomEnergy() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

