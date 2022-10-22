import java.util.ArrayList;
import java.util.Random;

public class Logic {
    String userGuess;
    int bullCount = 0;
    int cowsCount = 0;
    int guessNumber = 0;
    ArrayList<String> guesses = new ArrayList<String>();

    /*
    This method shows the user the numbers of the guesses that took him to reach the right answer
    Additionally, the user will be asked if they wish to play the game again\
     */
    public void gameEnd()
    {

    }

    /*
    Generates number according to the game rules
     */
    public String randomNumber()
    {
        Random rand = new Random();
        int digitOne, digitTwo, digitThree, digitFour;
        String guess;
        digitOne = rand.nextInt(10);
        digitTwo = rand.nextInt(10);
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
    public boolean guessValidation(String guess){
        // Validate the length of the guess
        int validNumberOfDigits = 4;


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
        return validDifferentDigits(guess);
    }

    /*
    This method get the number that the user wrote and return the number of Cows and Bulls accordingly
     */
    public String guessComparison(String guess)
    {
        return "Hello";
    // Use concat for the return string
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



}
