import javax.swing.JOptionPane;

public class Game {
    public static void main(String args []){

        // Holds value if the player want to play, when he decide to quit the value will be false and the game will finish
        boolean gameActive = true;

        while (gameActive == true)
        {
            JOptionPane.showMessageDialog(null, "Welcome to Cows And Bulls\nPlease enter your guess:");
        }

    }
}
