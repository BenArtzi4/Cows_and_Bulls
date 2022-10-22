import javax.swing.JOptionPane;

public class Game {
    public static void main(String [] args){

        // Holds value if the player want to play, when he decide to quit the value will be false and the game will finish
        boolean gameOn = true;
        boolean rightGuess;
        String comparison;
        String guess;
        String title = "Cows and Bulls";
        String gameMessage;
        String reGame;

        Logic game = new Logic();

        while (gameOn)
        {
            game.restart();
            rightGuess = false;
            while (!rightGuess)
            {
                gameMessage = "Hello, Please enter your guess\nNumber of guesses:" + game.guessesNumber +"\nYour previous guesses\n " + game.returnGuesses();
                guess = JOptionPane.showInputDialog(null, gameMessage, title, JOptionPane.PLAIN_MESSAGE);
                // If X button pressed we will quit
                if (guess == null)
                {
                    System.exit(0);
                }
                while (!game.guessValidation(guess))
                {
                    JOptionPane.showMessageDialog(null, "Invalid input!\nOnly four different digits must be entered ", "Error", JOptionPane.ERROR_MESSAGE);
                    guess = JOptionPane.showInputDialog(null, gameMessage, title, JOptionPane.PLAIN_MESSAGE);
                }

                comparison = game.guessComparison(guess);

                /*
                right guess
                 */
                if (comparison.charAt(3) != 'r')
                {
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
                    if (reGame.equals("1"))
                    {
                        gameOn = true;
                    }
                }
                  /*
                wrong guess
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
