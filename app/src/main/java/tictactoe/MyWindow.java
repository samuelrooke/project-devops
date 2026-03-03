package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;


public final class MyWindow extends JFrame {

    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 400;

    private boolean isXTurn = true;

    public MyWindow() {
        super("Professional Tic-Tac-Toe");
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.setFont(new Font("Arial", Font.BOLD, 60));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.CYAN);

            button.addActionListener(e -> {
                if (button.getText().equals("")) {
                    button.setText(isXTurn ? "X" : "O");
                    isXTurn = !isXTurn;
                }
            });

            add(button);
        }
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}