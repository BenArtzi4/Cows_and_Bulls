import javax.swing.JOptionPane;

public class Game
{
    public static void main(String [] args)
    {
        // Holds value if the player want to play, when he decide to quit the value will be false and the game will finish
        boolean gameOn = true;
        boolean rightGuess;
        String comparison;
        String guess;
        String title = "Cows and Bulls";
        String gameMessage;
        String reGame;
        // Creating an object to use in the game logic
        Logic game = new Logic();
        // As long as the user wants to continue playing, we will not exit the game loop
        while (gameOn)
        {
            // Resetting the variables in the game logic
            game.restart();
            rightGuess = false;
            // As long as the user does not guess the correct number, we will continue the round
            while (!rightGuess)
            {
                gameMessage = "Hello, Please enter your guess\nNumber of guesses:" + game.getGuessesNumber() +"\nYour previous guesses\n " + game.returnGuesses();
                guess = JOptionPane.showInputDialog(null, gameMessage, title, JOptionPane.PLAIN_MESSAGE);
                // If X button pressed we will quit without error
                if (guess == null)
                {
                    System.exit(0);
                }
                /*
                If the user entered a value no that does not match the rules,
                we will continue the loop that asks him for a correct value according to the rules of the game (four different numbers)
                 */
                while (!game.guessValidation(guess))
                {
                    JOptionPane.showMessageDialog(null, "Invalid input!\nOnly four different digits must be entered ", "Error", JOptionPane.ERROR_MESSAGE);
                    guess = JOptionPane.showInputDialog(null, gameMessage, title, JOptionPane.PLAIN_MESSAGE);
                }

                // We will check if the guess is correct and if not, then how many cows and how many bulls did he get
                comparison = game.guessComparison(guess);

                /*
                As soon as the user is right the third letter of the string returned from the method is not 'r'
                And we will know that the user's guess is correct
                 */
                if (comparison.charAt(3) != 'r')
                {
                    /*
                    Displaying a message to the user detailing the number of attempts it took him to guess the correct number,
                    the history of guesses and an offer to play again
                    */
                    String endGameMessage = "Well done, you guessed the right number: " + game.getSolution() +
                            " on attempt number:" + game.getGuessesNumber() +"\nGuesses history:\n" + game.returnGuesses() +
                            "\n Enter 1 to play again, otherwise enter any other character";

                    rightGuess = true;
                    gameOn = false;
                    reGame = JOptionPane.showInputDialog(null, endGameMessage, "Well Done", JOptionPane.PLAIN_MESSAGE);
                    // If X button pressed
                    if (reGame == null)
                    {
                        System.exit(0);
                    }
                    // According to the message written to the user, he will play again only if he entered the character 1 only
                    if (reGame.equals("1"))
                    {
                        gameOn = true;
                    }
                }
                  /*
                  If the user's guess was incorrect, we will display a message and add his guess and the result he got to the array that holds his entire history of guesses
                 */
                else
                {
                    game.addOneToGuessesNumber();
                    game.addToGuesses(comparison);
                    System.out.println("Solution: " + game.getSolution());
                }
            }
        }
    }
}
