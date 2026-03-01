package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public final class MyWindow extends JFrame{

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;

    public MyWindow() {
        super("Tic-Tac-Toe");

        setLayout(new GridLayout(3, 3)); 

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(""); 
            add(button);
        }

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
    }
}