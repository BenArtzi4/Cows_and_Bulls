import java.util.ArrayList;
import java.util.Random;

public class Logic {

    static int validNumberOfDigits = 4;
    private String solution;
    private final ArrayList<String> guesses;
    int guessesNumber;


    public Logic()
    {
        this.solution = randomNumber();
        this.guesses = new ArrayList<>();
        this.guessesNumber = 0;
    }

    public String getSolution() {
        return solution;
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }

    public void addToGuesses(String guess) {
        this.guesses.add(guess + "\n");
    }

    public int getGuessesNumber() {
        return guessesNumber;
    }

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
        int bulls = 0;
        int cows = 0;

        for (int i = 0 ; i < validNumberOfDigits ; i++)
        {
            if (guess.charAt(i) == solution.charAt(i))
            {
                bulls++;
            }
            else
            {
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

    public String returnGuesses()
    {
        String stringGuesses = "";
        for (String guess : this.guesses) {
            stringGuesses = stringGuesses.concat(guess);
        }
        return stringGuesses;
    }




}
