package com.priceline.chutes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void aChuteShouldSkipSquaresReversed(){
        BoardSquare square = new BoardSquare(true, false, 10);
        assertTrue(square.getNumberSquaresToSkip() < 0);
    }

    @Test
    public void aLadderShouldSkipSquaresForward() {
        BoardSquare square = new BoardSquare(false, true, 5);
        assertTrue(square.getNumberSquaresToSkip() > 0, "Ladders should result in a positive skip value.");
    }


    @Test
    public void aNeutralSquareShouldNotSkipSquares() {
        BoardSquare square = new BoardSquare(false, false, 0);
        assertEquals(square.getNumberSquaresToSkip(), 0, "Neutral squares should not skip any squares.");
    }


    @Test
    public void aSquareCannotBeBothChuteAndLadder() {
        BoardSquare square = new BoardSquare(true, true, 10);
        assertEquals(square.getNumberSquaresToSkip(), 0, "A square cannot be both a chute and a ladder.");
    }

    @Test
    public void aSquareWithZeroSquaresToSkipShouldNotMove() {
        BoardSquare square = new BoardSquare(true, false, 0);
        assertEquals(square.getNumberSquaresToSkip(), 0, "A square with zero squares to skip should not result in movement.");
    }

    @Test
    public void aLadderWithNegativeSquaresToSkipShouldBehaveAsLadder() {
        BoardSquare square = new BoardSquare(false, true, -5);
        assertTrue(square.getNumberSquaresToSkip() < 0, "Ladders with negative skips should still result in positive movement.");
    }

    @Test
    public void aChuteWithNegativeSquaresToSkipShouldBehaveAsChute() {
        BoardSquare square = new BoardSquare(true, false, -10);
        assertTrue(square.getNumberSquaresToSkip() < 0, "Chutes with negative skips should result in negative movement.");
    }

    @Test
    public void defaultConstructorShouldInitializeNeutralSquare() {
        BoardSquare square = new BoardSquare();
        assertEquals(square.getNumberSquaresToSkip(), 0, "The default constructor should create a neutral square with no skips.");
    }
}
