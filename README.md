# Chutes and Ladders Game

This project implements a simple command-line version of the Chutes and Ladders game in Java. The game allows 2 to 4 players to play, with each player taking turns spinning a spinner to determine their moves on the board. The first player to reach square 100 wins the game. The game includes features such as:

- Dynamic determination of the number of players
- Random play order determination at the beginning of the game
- Ability to handle chutes and ladders on the game board
- Alternative winning condition: landing on ladder square #80 immediately takes a player to square #100

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- IDE (e.g., IntelliJ IDEA, Eclipse) for running and testing the code

### Running the Game

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Navigate to the `com.priceline.chutes` package.
4. Run the `Game` class to start the game.
5. Follow the on-screen instructions to play the game.

## Project Structure

The project consists of the following classes:

- `Game`: Main class responsible for managing the game flow.
- `Board`: Represents the game board containing the squares.
- `BoardSquare`: Represents a square on the game board, including chutes and ladders.
- `Player`: Represents a player in the game.

## Running Tests

The project includes test cases for the `BoardSquare` class. To run the tests:

1. Navigate to the `com.priceline.chutes` package.
2. Open the `BoardSquareTest` class.
3. Run the test cases to ensure the functionality of the `BoardSquare` class.

## Authors

- Sourabh Suman