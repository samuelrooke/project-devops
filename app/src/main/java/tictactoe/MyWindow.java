package tictactoe;

import javax.swing.*;
import java.awt.*;

public final class MyWindow extends JFrame {
    private boolean isXTurn = true;
    private JButton[] buttons = new JButton[9];
    private JLabel statusLabel;
    private Logic logic;

    public void setIsXTurn(boolean isXTurn) { this.isXTurn = isXTurn; }
    public boolean getIsXTurn() { return isXTurn; }

    public MyWindow() {
        super("Professional Tic-Tac-Toe");

        setLayout(new BorderLayout());
        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        logic = new GameLogic(this, statusLabel, buttons);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 55));
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.WHITE);


            final int index =i;
            buttons[i].addActionListener(e -> {
                if (buttons[index].getText().equals("")) {
                    buttons[index].setText(isXTurn ? "X" : "O");
                    logic.checkWinner();
                    isXTurn = !isXTurn;

                    statusLabel.setText(isXTurn ? "Player X's Turn" : "Player O's Turn");

                }
            });

            gridPanel.add(buttons[i]);
        }
        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}