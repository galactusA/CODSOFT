import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        int score = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");
            
            for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                if (attempts == numberOfAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game Over! Your score: " + score);
        scanner.close();
    }
}