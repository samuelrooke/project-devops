package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;


public final class MyWindow extends JFrame {

    private boolean isXTurn = true;
    private JButton[] buttons = new JButton[9];

    public MyWindow() {
        super("Professional Tic-Tac-Toe");
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 55));
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.WHITE);

            final int index =i;
            buttons[i].addActionListener(e -> {
                if (buttons[index].getText().equals("")) {
                    buttons[index].setText(isXTurn ? "X" : "O");
                    checkWinner();
                    isXTurn = !isXTurn;
                }
            });

            add(buttons[i]);
        }
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void checkWinner() {
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


    private void resetBoard() {
        for (JButton b : buttons) b.setText("");
        isXTurn = true;
    }
}