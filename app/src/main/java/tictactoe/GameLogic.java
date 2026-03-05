package tictactoe;

import javax.swing.JLabel;
import javax.swing.JButton;

public final class GameLogic implements Logic {

    private MyWindow parentWindow;
    private JLabel statusLabel;
    private JButton[] buttons;
    /**
     * Private no-param constructor for GameLogic
     */
    private GameLogic() { }

    /**
     * Constructor for GameLogic that takes
     * a MyWindow, JLabel and Jbutton[] instances as arguments.
     * @param parentWindow The composite MyWindow that has this as a field
     * @param statusLabel The JLabel label for displaying whose turn it is
     * @param buttons The JButton[] that contains the buttons for parentWindow
     * that are pressed when the game is played
     */
    public GameLogic(MyWindow parentWindow, JLabel statusLabel, JButton[] buttons) {
        this.parentWindow = parentWindow;
        this.statusLabel = statusLabel;
        this.buttons = buttons;
    }

    @Override
    public boolean checkWinner() {
        int[][] winConditions = {
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