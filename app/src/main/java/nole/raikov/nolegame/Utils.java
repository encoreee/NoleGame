package nole.raikov.nolegame;

import java.util.Random;

class Utils {

    private static final Random RANDOM = new Random();

    static int randInt(int min, int max) {
        return RANDOM.nextInt(max);
    }
}