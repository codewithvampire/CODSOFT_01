import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        int lowerLimit = 1;
        int upperLimit = 100;
        int secretNumber = new Random().nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
            int userGuess = scanner.nextInt();

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number " + secretNumber + "!");
                break;
            } else if (userGuess < secretNumber) 
                System.out.println("Too low. Try again.");
            else 
                System.out.println("Too high. Try again.");

            totalAttempts++;

            if (totalAttempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                break;
            }
        }

        roundsPlayed++;

        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();
        if (!playAgain.equals("yes")) 
            System.out.println("Thanks for playing! Your total score is " + (roundsPlayed - totalAttempts) + ".");
        else
            main(args);
        scanner.close();
    }
}
