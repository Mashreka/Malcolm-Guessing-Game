//Vidareutvecklingen av projektet
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private static Random random = new Random();
    private static int randomNumber;
    private static int tries;
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label;
    private static JTextField textField;
    private static JButton button;
    private static JButton yesButton;
    private static JButton noButton;

    public static void main(String[] args) {
        initializeGUI(); //calls the initializeGUI method to set up the graphical user interface
        initializeGame(); //calls the initializeGame method to initialize the game variables

        /*
           when button is clicked, it retrieves the user's guess from the text field,
           increments the number of tries,
           and checks the guess against the random number.
           Depending on the result, it displays the appropriate message
           using the showGameOverMessage or showWrongGuessMessage methods.
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(textField.getText());
                tries++;

                if (checkGuessResult(randomNumber, guess) == 0) {
                    showGameOverMessage("Congratulations! You guessed it right.\nIt took you " + tries + " tries.\nDo you want to play again?");
                } else if (checkGuessResult(guess, randomNumber) == +1) {
                    showWrongGuessMessage("Wrong guess! The number is higher. Try again.");
                } else {
                    showWrongGuessMessage("Wrong guess! The number is lower. Try again.");
                }
            }
        });
        /*
            when the buttons are clicked,
            yesButton resets the game by calling the resetGame method,
            while the noButton exits the program.
         */

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //initializeGUI method sets up the graphical user interface
    public static void initializeGUI() {
        frame = new JFrame("Guessing Game");
        panel = new JPanel();
        label = new JLabel("Guess a number between 1 - 100: ");
        textField = new JTextField(10);
        button = new JButton("Guess");
        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    //initializeGame method initializes the game by generating a random number
    public static void initializeGame() {
        randomNumber = random.nextInt(100) + 1;
        tries = 0;
    }
    /*
         checkGuessResult method compares the user's guess with the random number
         and returns an integer value indicating the result
     */
    public static int checkGuessResult(int randomNumber, int guess) {
        if (guess == randomNumber) {
            return 0; // Correct guess
        } else if (guess < randomNumber) {
            return -1; // Guess is lower than the random number
        } else {
            return +1; // Guess is higher than the random number
        }
    }
    // showGameOverMessage and showWrongGuessMessage methods display a message dialog with the provided message using the JOptionPane class.
    public static void showGameOverMessage(String message) {
        int playAgain = JOptionPane.showConfirmDialog(frame, message, "Game Over", JOptionPane.YES_NO_OPTION);
        if (playAgain == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    public static void showWrongGuessMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
    //resetGame method resets the game by calling the initializeGame method
    //It also clears the text field by setting its text to an empty string.
    public static void resetGame() {
        initializeGame();
        textField.setText("");
    }
}
