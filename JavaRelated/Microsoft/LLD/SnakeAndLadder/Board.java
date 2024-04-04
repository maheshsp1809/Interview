package Microsoft.LLD.SnakeAndLadder;

import java.util.*;

class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize snakes and ladders positions
        snakes.put(98, 28);
        snakes.put(95, 56);
        snakes.put(85, 14);
        snakes.put(72, 35);
        snakes.put(63, 22);
        snakes.put(51, 19);

        ladders.put(6, 53);
        ladders.put(11, 49);
        ladders.put(26, 67);
        ladders.put(38, 79);
        ladders.put(45, 86);
        ladders.put(61, 93);
    }

    public int getNextPosition(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > size) {
            return currentPosition;
        }
        if (snakes.containsKey(newPosition)) {
            return snakes.get(newPosition);
        } else if (ladders.containsKey(newPosition)) {
            return ladders.get(newPosition);
        }
        return newPosition;
    }

    public boolean hasWon(int position) {
        return position == size;
    }
}
