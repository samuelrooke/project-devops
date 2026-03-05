package tictactoe;

import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;

public final class MyWindow extends JFrame {
    /**
     * A boolean for checking whether it's
     * the player X's turn.
     */
    private boolean isXTurn = true;
    /**
     * The array of JButtons that form the tictactoe
     * grid.
     */
    private JButton[] buttons = new JButton[9];
    /**
     * The JLabel used for displaying which player's
     * turn it is.
     */
    private JLabel statusLabel;
    /**
     * The instance of class implementing Logic.
     * Used for checking the winner of the game
     * and resetting the board.
     */
    private Logic logic;
    private int moveCount = 0;
    private boolean isAiEnabled = true; // AI

    /**
     * Setter for isXTurn.
     * @param isXTurn The boolean field for checking
     * if it's the player X's turn
     */
    public void setIsXTurn(boolean isXTurn) {
        this.isXTurn = isXTurn;
    }
    /**
     * Getter for isXTurn.
     * @return The boolean field for checking
     * if it's the player X's turn
     */
    public boolean getIsXTurn() {
        return isXTurn;
    }

    /**
     * A no-param constructor for MyWindow.
     */
    public MyWindow() {
        super("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

/**
 * Initializes the game board for the specified number of players.
 * Sets up buttons, status label, and action listeners.
 */
    public void initializeGame(int playerCount) {
        this.isAiEnabled = (playerCount == 1);
        this.moveCount = 0;
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());

        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        // Panel to hold 3x3 grid of buttons
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        logic = new GameLogic(this, statusLabel, buttons);

    // Loop to initialize all 9 grid buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 55));
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setForeground(Color.WHITE);

    // Adds an action listener to each button to handle moves,
    // check for a winner or draw, update the status label,
    // and trigger AI moves if enabled.
            final int index = i;
            buttons[i].addActionListener(e -> {
                if (buttons[index].getText().equals("")) {
                    buttons[index].setText(isXTurn ? "X" : "O");
                    moveCount++;

                    if (logic.checkWinner()) {
                        statusLabel.setText("Player " + (isXTurn ? "X" : "O") + " Wins!");
                        for (JButton b : buttons) b.setEnabled(false);
                        showEndGameOptions();
                    }
                    else if (moveCount == 9) {
                        statusLabel.setText("It's a Draw!");
                        showEndGameOptions();
                    }
                    else {
                        isXTurn = !isXTurn;
                        statusLabel.setText("Player " + (isXTurn ? "X" : "O") + "'s Turn");

                        if (isAiEnabled && !isXTurn) {
                            SwingUtilities.invokeLater(() -> performAiMove());
                        }
                    }
                }
            });
            gridPanel.add(buttons[i]);
        }
// Adds the game grid and status label to the window,
// then refreshes the layout and repaints the frame.
        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }

/** Shows options after the game ends. Allows returning to the main menu. */
    private void showEndGameOptions() {
        JPanel bottomPanel = new JPanel();
        JButton menuButton = new JButton("Back to Menu");
// Adds an action listener to the menuButton that
// clears the current content and shows the main menu.
        menuButton.addActionListener(e -> {
            this.getContentPane().removeAll();
            this.add(new Menu(this));
            this.revalidate();
            this.repaint();
        });
// Adds a panel at the bottom of the window containing
// the "Back to Menu" button and refreshes the layout.
        bottomPanel.add(menuButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
/** Makes the AI perform a move by clicking a random available button. */
    private void performAiMove() {
    int moveIndex = logic.getSmartMove();
        if (moveIndex != -1) {
            buttons[moveIndex].doClick();
        }
    }
}
