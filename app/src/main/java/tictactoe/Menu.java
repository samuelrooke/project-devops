package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JFrame window;
    private int playerCount = 0;

    /**
     *Creates menu panel that contains:
     <ul>
     *  <li>Title label</li>
     *  <li>Start button</li>
     *  <li>Quit button</li>
     *</ul>
     *
     * @param window the parent JFrame used as a container
     * @param TBD the game panel that starts when user presses start and chooses the players
     */
    public Menu(JFrame window) { // this needs the game panel as an argument
        this.window = window;
        // Need the file that has the game logic here "this.<file> = <file>;""
        initialize();
    }

    private int playerCount = 0; // Playercount is used in start buttons Actionlistener method to decide how many players will play the game


    /**
     * This method creates the title, start button and quit buttons for the menu panel.
     *
     */
    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout should make the items inside from top to bottom when its Y.AXIS
        JLabel titleLabel = new JLabel("Tic-Tac-Toe"); // Label object
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object

        JButton startButton = new JButton("Start"); // Button object
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object
        startButton.addActionListener(new ActionListener() {

            /**
             * This creates a panel that allows the user to decide the playercount
             *
             * @param Actionevent ActionEvent is Actionlisteners method
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Creates the pop up where user can choose the playercount
                 * takes the arguments "parent window", "string" and "boolean"
                 * window is the parent frame
                 * string is the title
                 * true makes the panel modal which means that it blocks access to the owner
                 */
                JDialog dialog = new JDialog(window, "Choose your players", true); // Creates object "dialog"


                /**
                 * <p>DialogPanel holds the dialoglabel, playerOne button and playerTwo button</p>
                 * dialogLabel is used as a title
                 * buttons decide how many players are playing
                 */
                JPanel dialogPanel = new JPanel(); // creates object "dialogPanel"

                dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS)); // Makes the objects inside to go from top to bottom

                JLabel dialogLabel =  new JLabel("Choose how many players"); // Label object, used as a title for the dialog

                JButton onePlayer = new JButton("1 Player");
                onePlayer.addActionListener(ev -> {
                    playerCount = 1;
                    dialog.dispose(); // Closes the pop up
                });

                JButton twoPlayer = new JButton("2 Players");
                 twoPlayer.addActionListener(ev -> {
                    playerCount = 2;
                    dialog.dispose(); // Closes the pop up
                });


                dialogLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centers label
                onePlayer.setAlignmentX(Component.CENTER_ALIGNMENT); // Centers button 1
                twoPlayer.setAlignmentX(Component.CENTER_ALIGNMENT); // Centers button 2

                // Lets add the items to the dialogPanel
                dialogPanel.add(dialogLabel);
                dialogPanel.add(onePlayer);
                dialogPanel.add(twoPlayer);

                // Lets add the dialogPanel to the dialog
                dialog.add(dialogPanel);

                dialog.pack(); // Make sure it fits
                dialog.setLocationRelativeTo(window); // Center the pop up
                dialog.setVisible(true); // Shows the pop up

                // Need to add the method to go to the game here "<file>.<method>(playercount);" (playercount is private field in menu class)
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