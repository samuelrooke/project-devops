package tictactoe;

import javax.swing.*;
import java.awt.*;

/**
 * MyWindow handles the main GUI window for the Tic-Tac-Toe game.
 * It manages game state, user interactions, and delegates win logic to GameLogic.
 */

public final class MyWindow extends JFrame {
    private boolean isXTurn = true;
    private JButton[] buttons = new JButton[9];
    private JLabel statusLabel;
    private Logic logic;
    private int moveCount = 0;

    /** Sets which player's turn it is. */
    public void setIsXTurn(boolean isXTurn) { this.isXTurn = isXTurn; }

    /** Returns true if it's X's turn, false otherwise. */
    public boolean getIsXTurn() { return isXTurn; }

    /** Initializes the main Tic-Tac-Toe window and sets default size and behavior. */
    public MyWindow() {
        super("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initializeGame(int playerCount) {
        this.moveCount = 0;
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());

        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        logic = new GameLogic(this, statusLabel, buttons);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 55));
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setForeground(Color.WHITE);

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
                    }
                }
            });
            gridPanel.add(buttons[i]);
        }

        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }
    /**
    * Displays the end-of-game options, allowing the player to return to the menu.
    */
    private void showEndGameOptions() {
        JPanel bottomPanel = new JPanel();
        JButton menuButton = new JButton("Back to Menu");

        menuButton.addActionListener(e -> {
            this.getContentPane().removeAll();
            this.add(new Menu(this));
            this.revalidate();
            this.repaint();
        });

        bottomPanel.add(menuButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
}