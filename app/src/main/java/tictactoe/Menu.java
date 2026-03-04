package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JPanel {
    public Menu() {
        initialize();
    }

    private void initialize() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS, 10, 5)); // BoxLayout should make the items inside from top to bottom
        JLabel titleLabel = new JLabel("Tic-Tac-Toe");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object


        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog dialog = new JDialog(window, "Choose your players", true);

                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));

                JLabel dialogLabel =  new JLabel("Choose how many players");
                JButton onePlayer = new JButton("1 Player");
                JButton twoPlayer = new JButton("2 Players");


                dialogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                onePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
                twoPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

                dialogPanel.add(dialogLabel);
                dialogPanel.add(onePlayer);
                dialogPanel.add(twoPlayer);

                dialog.add(dialogPanel);

                dialog.pack();
                dialog.setLocationRelativeTo(window);
                dialog.setVisible(true);
            }
        });

        JButton quitButton = new JButton("Quit"); // Button for quitting the game
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object
        quitButton.addActionListener(e -> System.exit(0));

        add(titleLabel);
        add(startButton);
        add(quitButton);
    }
}