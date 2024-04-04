package Microsoft.LLD.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Player class

// Board class

// Dice class

// Game class
class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private Dice dice;

    public Game(int boardSize, int numPlayers) {
        board = new Board(boardSize);
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        currentPlayerIndex = 0;
        dice = new Dice();
    }

    public void start() {
        while (!isGameOver()) {
            Player currentPlayer = players[currentPlayerIndex];
            int diceRoll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);
            movePlayer(currentPlayer, diceRoll);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
        Player winner = getWinner();
        System.out.println("The winner is: " + winner.getName());
    }

    private void movePlayer(Player player, int diceRoll) {
        int currentPosition = player.getPosition();
        int newPosition = board.getNextPosition(currentPosition, diceRoll);
        player.setPosition(newPosition);
        System.out.println(player.getName() + " moved from " + currentPosition + " to " + newPosition);
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (board.hasWon(player.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private Player getWinner() {
        for (Player player : players) {
            if (board.hasWon(player.getPosition())) {
                return player;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Game game = new Game(100, 2); // Create a game with a board size of 100 and 2 players
        game.start();
    }
}
