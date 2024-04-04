package Microsoft.LLD.SnakeAndLadder;

import java.util.*;

class Dice {
    private static final Random random = new Random();

    public static int roll() {
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}
