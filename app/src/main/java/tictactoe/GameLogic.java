package tictactoe;

import javax.swing.JLabel;

public final class GameLogic implements Logic{

    private JLabel statusLabel;

    public void checkWinner() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pos : winConditions) {
            String b1 = buttons[pos[0]].getText();
            String b2 = buttons[pos[1]].getText();
            String b3 = buttons[pos[2]].getText();

            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Player " + b1 + " wins!");
                resetBoard();
            }
        }
    }

    public void resetBoard() {
        for (JButton b : buttons) b.setText("");
        isXTurn = true;
        statusLabel.setText("Player X's Turn");
    }
}