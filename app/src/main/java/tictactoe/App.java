package tictactoe;

import javax.swing.SwingUtilities;
/**
 * Main application class that launches the Tic-Tac-Toe window.
 */
public final class App {
    /**
     * Private constructor for App.
     */
    private App() {

    }
    /**
     * Entry point for the app.
     */
    public static void main (final String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyWindow window = new MyWindow();
            Menu menuPanel = new Menu(window);
            window.setContentPane(menuPanel);
            window.setVisible(true);
        });
    }
}
