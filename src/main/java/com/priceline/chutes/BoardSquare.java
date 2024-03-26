package com.priceline.chutes;

public class BoardSquare {
    private final boolean isChute;
    private final boolean isLadder;
    private final int numberSquaresToSkip;

    BoardSquare(){
        this(false, false, 0);
    }
    BoardSquare(boolean isChute, boolean isLadder, int numberSquaresToSkip){
        this.isChute = isChute;
        this.isLadder = isLadder;
        this.numberSquaresToSkip = numberSquaresToSkip;
    }

    public int getNumberSquaresToSkip() {
        // Check for invalid configuration: square cannot be both chute and ladder
        if (isChute && isLadder) {
            return 0; // No movement if square is mis-configured
        } else if (isLadder) {
            return numberSquaresToSkip; // Ladder moves you forward
        } else if (isChute) {
            return numberSquaresToSkip < 0 ? numberSquaresToSkip : -numberSquaresToSkip; // Chute moves you backward, ensuring negative movement
        } else {
            return 0; // Neutral squares don't move you
        }
    }
}
