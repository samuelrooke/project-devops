package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;


public final class MyWindow extends JFrame {

    private boolean isXTurn = true;

    public MyWindow() {
        super("Professional Tic-Tac-Toe");
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.setFont(new Font("Arial", Font.BOLD, 55));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);

            button.addActionListener(e -> {
                if (button.getText().equals("")) {
                    button.setText(isXTurn ? "X" : "O");
                    isXTurn = !isXTurn;
                }
            });

            add(button);
        }
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}