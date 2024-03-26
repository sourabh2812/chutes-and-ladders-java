package com.priceline.chutes;

import java.util.*;

public class Game {

    private final List<Player> players = new ArrayList<>();
    private final Random random = new Random();
    private final Board board = new Board();
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;

    public Game() {
        Scanner scanner = new Scanner(System.in);

        // Get the number of players
        int numPlayers;
        do {
            System.out.print("Enter the number of players (2-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 2 and 4.");
                scanner.next();
            }
            numPlayers = scanner.nextInt();
            if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
                System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            }
        } while (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS);

        // Get player names
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }

        scanner.close();

        // Determine play order
        determinePlayOrder();
    }

    private void determinePlayOrder() {
        System.out.println("Determining play order...");
        Map<Player, Integer> spins = new HashMap<>();
        players.forEach(player -> spins.put(player, spin()));
        players.sort(Comparator.comparing(spins::get).reversed());
        System.out.println("Play order determined.");
    }

    private int spin() {
        return random.nextInt(6) + 1;
    }

    public void playGame() {
        while (true) {
            for (Player currentPlayer : players) {
                System.out.println(currentPlayer.getName() + "'s turn.");
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;

                // Check for the winning condition via ladder square #80
                if (nextPosition == 80) {
                    nextPosition = 100;
                    currentPlayer.setPosition(nextPosition);
                    System.out.println(currentPlayer.getName() + " wins by climbing to square 100!");
                    return;
                }

                if (nextPosition > 100) {
                    continue;
                }

                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();

                currentPlayer.setPosition(Math.min(nextPosition, 100));
                if (nextPosition >= 100) {
                    System.out.println("The winner is: " + currentPlayer.getName());
                    return; // Game ends
                }
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
