package tictactoe;

/**
 * Interface defining the core game logic for Tic-Tac-Toe.
 * Includes methods for checking the winner, resetting the board,
 * and calculating AI moves.
 */
public interface Logic {
    /**
     * A method for checking the game's winner.
     */
    boolean checkWinner();
    /**
     * A method for resetting the board or the
     * game's state.
     */
    void resetBoard();
    /**
     * Calculates a valid move for the AI by identifying empty positions
     * on the board and selecting one at random.
     * @return The index of the chosen button (0-8), or -1 if no moves are available.
     */
    int getRandomMove();
    /**
     * Calculates an optimized move for the AI by analyzing the board for
     * immediate threats or winning opportunities.
     * @return The index of the chosen button (0-8), or -1 if no moves are available.
     */
    int getSmartMove();
}