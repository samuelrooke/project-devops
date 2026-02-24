package tictactoe;

import javax.swing.JFrame;

public final class MyWindow extends JFrame{

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;

    public MyWindow() {
        super("window");
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}