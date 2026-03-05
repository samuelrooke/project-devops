package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class is Menu panel for tic tac toe
 *
 */
public class Menu extends JPanel {
    private JFrame window;
    private int playerCount = 0; // is used in startbutton, decides how many playeres are playing the game

    Font titleFont = new Font("Arial", Font.BOLD, 30); // this font is used for the titles
    Font buttonFont = new Font("Arial", Font.BOLD, 18); // this font is used for the buttons
    Font dialogFont = new Font("Arial", Font.PLAIN, 16); // this font is used for the dialog object in start button.

    /**
     * This is constructor for the menu class
     *
     * @param window this is the mainframe of the project
     */
    public Menu(JFrame window) {
        this.window = window;
        initialize();
    }

    /**
     * This method is used to initialize the main title, start button and quit button
     */
    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // This is the layout of the menu, made sure that the items go from top to bottom

        JLabel titleLabel = new JLabel("Tic-Tac-Toe"); // title of the game
        titleLabel.setFont(titleFont); // uses the titlefont variable
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure that the labels text is in center of the item

        JButton startButton = new JButton("Start"); // button to start the game
        startButton.setFont(buttonFont); // uses the buttonfont variable
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure that button is in the center of the item
        startButton.setMaximumSize(new Dimension(120, 50)); // max size so that the buttons are equal in size

        startButton.addActionListener(new ActionListener() {

            /**
             * This method is to make sure that start button will work as intended. Lets the user decide between playing with ai or as 2 players
             *
             * @param ActionEvent is Actionlisteners parameter that needs to be done so the button can take inputs.
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 * dialog is used as a pop up when you click the start button, it takes the arguments:
                 * parent frame (in this case its mainframe named window),
                 * string as a title for the pop up,
                 * boolean, deciding whether the pop up is modal or not.
                 */
                JDialog dialog = new JDialog(window, "Choose your players", true); // the pop up container
                JPanel dialogPanel = new JPanel(); // object where we add the title, and buttons for deciding how many players
                dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS)); // makes sure that items go from top to bottom

                JLabel dialogLabel = new JLabel("Choose how many players"); // used as a title for the pop up
                dialogLabel.setFont(titleFont); // sets the font, uses the titlefont from earlier
                dialogLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure the item is centered.

                JButton onePlayer = new JButton("1 Player"); // button for choosing to play on your own against ai
                onePlayer.setFont(buttonFont); // sets the font, uses the earlier button font
                onePlayer.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure the the item is centered
                onePlayer.setMaximumSize(new Dimension(160, 70)); // max size so that the buttons are equal in size
                onePlayer.addActionListener(ev -> {
                    playerCount = 1; // playing on your own against ai
                    dialog.dispose(); // closes pop up
                });

                JButton twoPlayer = new JButton("2 Players"); // button for choosing to play with someoeone
                twoPlayer.setFont(buttonFont); // sets the font, uses the earlier button font
                twoPlayer.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure the the item is centered
                twoPlayer.setMaximumSize(new Dimension(160, 70)); // max size so that the buttons are equal in size
                twoPlayer.addActionListener(ev -> {
                    playerCount = 2; // playing with someone
                    dialog.dispose(); // pop up closes
                });

                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10))); // adds 10 pixels of space between the items
                dialogPanel.add(dialogLabel); // adds the title
                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10))); // adds 10 pixels of space between the items
                dialogPanel.add(onePlayer); // adds playerOne button
                dialogPanel.add(twoPlayer);// adds playerTwo button
                dialogPanel.add(Box.createRigidArea(new Dimension(0, 10))); // adds 10 pixels of space between the items

                dialog.add(dialogPanel); // adds the dialog.panel to the pop up
                dialog.pack(); // resizes the window to fit the contents
                dialog.setLocationRelativeTo(window); // centers the pop up relative to the main JFrame
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // closes the pop up when pressed "x"
                dialog.setVisible(true); // sets the pop up visible

                if (playerCount > 0) { // initializes the game panel
                    ((MyWindow) window).initializeGame(playerCount);
                }

            }
        });

        JButton quitButton = new JButton("Quit"); // the quit button to exit the application
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // makes sure the item is centered
        quitButton.setFont(buttonFont); // sets the font, uses the earlier button font
        quitButton.setMaximumSize(new Dimension(120, 50)); // sets maximum size for the button so that they are the same size
        quitButton.addActionListener(e -> System.exit(0)); // exits the application when pressed.

        add(Box.createVerticalGlue());
        add(titleLabel); // adds the main title
        add(Box.createRigidArea(new Dimension(0, 20))); // space between items
        add(startButton); // adds the start button
        add(Box.createRigidArea(new Dimension(0, 10))); // space betwee items
        add(quitButton); // adds the quit button
        add(Box.createVerticalGlue());
    }
}
