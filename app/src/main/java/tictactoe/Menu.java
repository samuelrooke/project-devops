package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu panel for the Tic-Tac-Toe game.
 * Displays the title and allows the player to start or quit the game.
 */
public class Menu extends JPanel {
    private JFrame window;
    private int playerCount = 0;

    public Menu(JFrame window) {
        this.window = window;
        initialize();
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Tic-Tac-Toe");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(window, "Choose your players", true);
                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));

                JLabel dialogLabel = new JLabel("Choose how many players");
                dialogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton onePlayer = new JButton("1 Player");
                onePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
                onePlayer.addActionListener(ev -> {
                    playerCount = 1;
                    dialog.dispose();
                });

                JButton twoPlayer = new JButton("2 Players");
                twoPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
                twoPlayer.addActionListener(ev -> {
                    playerCount = 2;
                    dialog.dispose();
                });

                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                dialogPanel.add(dialogLabel);
                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                dialogPanel.add(onePlayer);
                dialogPanel.add(twoPlayer);
                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10)));

                dialog.add(dialogPanel);
                dialog.pack();
                dialog.setLocationRelativeTo(window);
                dialog.setVisible(true);

                if (playerCount > 0) {
                    ((MyWindow) window).initializeGame(playerCount);
                }
            }
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(e -> System.exit(0));

        add(Box.createVerticalGlue());
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(startButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(quitButton);
        add(Box.createVerticalGlue());
    }
}