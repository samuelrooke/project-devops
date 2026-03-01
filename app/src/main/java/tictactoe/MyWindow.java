package tictactoe;

import javax.swing.JFrame;

public final class MyWindow extends JFrame{

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;

    public MyWindow() {
        super("Tic-Tac-Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}