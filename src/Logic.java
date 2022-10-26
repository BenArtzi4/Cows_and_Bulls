import java.util.ArrayList;
import java.util.Random;

public class Logic {

    // An attribute that holds the number of digits at a valid guess
    private final int validNumberOfDigits = 4;
    // An attribute that holds the correct number that the user needs to guess
    private String solution;
    // An attribute that holds the guess history and result of the user
    private final ArrayList<String> guesses;
    // An attribute that holds the number that the user guessed
    private int guessesNumber;


    public Logic()
    {
        this.solution = randomNumber();
        this.guesses = new ArrayList<>();
        this.guessesNumber = 0;
    }

    /*
    A method that returns the correct solution
     */
    public String getSolution()
    {
        return solution;
    }

    /*
    A method that adds a guess to the history of guesses
     */
    public void addToGuesses(String guess)
    {
        this.guesses.add(guess + "\n");
    }

    /*
    A method that returns the number of guesses up to the current state of the game
    */
    public int getGuessesNumber()
    {
        return guessesNumber;
    }

    /*
    A method that adds 1 to the number of guesses after the user guesses
     */
    public void addOneToGuessesNumber()
    {
        this.guessesNumber++;
    }

    /*
    Generates number according to the game rules
     */
    static String randomNumber()
    {
        Random rand = new Random();
        int digitOne, digitTwo, digitThree, digitFour;
        String guess;
        digitOne = rand.nextInt(10);
        digitTwo = rand.nextInt(10);
        // Choose a random number from 0 to 9 (inclusive) and checking that all digits are different from each other
        while (digitTwo == digitOne)
        {
            digitTwo = rand.nextInt(10);
        }
        digitThree = rand.nextInt(10);
        while (digitThree == digitOne || digitThree == digitTwo)
        {
            digitThree = rand.nextInt(10);
        }
        digitFour = rand.nextInt(10);
        while (digitFour == digitOne || digitFour == digitTwo || digitFour == digitThree)
        {
            digitFour = rand.nextInt(10);
        }

        guess = String.valueOf(digitOne).concat(String.valueOf(digitTwo).concat(String.valueOf(digitThree).concat(String.valueOf(digitFour))));

        return guess;
    }

    /*
    This method check if the user guess is valid
    Return True if the guess if valid, else False
    User guess length must be 4 and contain only digits and each digit can appear maximum once
     */
    public boolean guessValidation(String guess)
    {
        // Validate the length of the guess
        if (guess.length() != validNumberOfDigits)
        {
            return false;
        }
        // Validate that the guess contains only digits
        for (int i = 0 ; i < validNumberOfDigits ; i++)
        {
            if (! Character.isDigit(guess.charAt(i)))
            {
                return false;
            }
        }
        // Checking using a method whether all digits are different from each other
        return validDifferentDigits(guess);
    }

    /*
    This method get the number that the user wrote and return the number of Cows and Bulls accordingly
    Also returns the result as a string
     */
    public String guessComparison(String guess)
    {
        int bulls = 0;
        int cows = 0;

        // Checking digits that are in the right place
        for (int i = 0 ; i < validNumberOfDigits ; i++)
        {
            if (guess.charAt(i) == solution.charAt(i))
            {
                bulls++;
            }
            else
            {
                // Checking whether there are digits that are in the solution but are in the wrong place
                for (int j = 0 ; j < validNumberOfDigits ; j++)
                {
                    if (guess.charAt(i) == solution.charAt(j))
                    {
                        cows++;
                        break;
                    }
                }
            }
        }
        //If the four digits are in the correct place then the answer is correct
        if (bulls == 4)
        {
            return "You guessed the right number\nWell Done ";
        }
        return "Your guess is: " + guess + " --> " + bulls + " Bulls and " + cows +" Cows";
    }

    // Get string in length of 4 and return if all the chars are different from each other
    public boolean validDifferentDigits(String word)
    {
        int validNumberOfDigits = 4;

        for (int i = 0 ; i < validNumberOfDigits ; i++)
        {
            for (int j = i+1 ; j < validNumberOfDigits ; j++)
            {
                if (word.charAt(i) ==  word.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void restart()
    {
        this.solution = randomNumber();
        this.guesses.clear();
        this.guessesNumber = 0;
    }

    // This method resets the data in preparation for a new game
    public String returnGuesses()
    {
        String stringGuesses = "";
        for (String guess : this.guesses)
        {
            stringGuesses = stringGuesses.concat(guess);
        }
        return stringGuesses;
    }
}
