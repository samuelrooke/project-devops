package tictactoe;

import javax.swing.JLabel;
import javax.swing.JButton;


// Game Loic handles the core game logic and rule processing.

public final class GameLogic implements Logic {

    private MyWindow parentWindow;
    private JLabel statusLabel;
    private JButton[] buttons;

    public GameLogic(MyWindow parentWindow, JLabel statusLabel, JButton[] buttons) {
        this.parentWindow = parentWindow;
        this.statusLabel = statusLabel;
        this.buttons = buttons;
    }

    @Override
    public boolean checkWinner() {           // Evaluates the board to determine if a player has won
        int[][] winConditions = {            // Winning combinations for rows, columns, and diagonals
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pos : winConditions) {
            String b1 = buttons[pos[0]].getText();
            String b2 = buttons[pos[1]].getText();
            String b3 = buttons[pos[2]].getText();

            if (!b1.isEmpty() && b1.equals(b2) && b2.equals(b3)) {
                return true;
            }
        }

        return false;
    }

    public void resetBoard() {
        for (JButton b : buttons) b.setText("");
        parentWindow.setIsXTurn(true);
        statusLabel.setText("Player X's Turn");
    }
}