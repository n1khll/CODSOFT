//Task 1 Number Game
import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter the range(lower-upper):");
        int l=s.nextInt(),u=s.nextInt();
        int a = 10, rNum, g, at, rt = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            rNum = r.nextInt(u - l + 1) + l;
            at = 0;
            System.out.println("\nRound " + (++rt) +
                    ": Guess a number between " + l + " and " + u);
            do {
                System.out.print("Enter your guess: ");
                g = s.nextInt();
                at++;
                if (g == rNum)
                    System.out.println("Congratulations! Your guess is correct." +
                            " It took you " + at + " attempts.");
                else if (g < rNum)
                    System.out.println("Too low! Try again.");
                else
                    System.out.println("Too high! Try again.");
            } while (g != rNum && at < a);
            System.out.println("The correct number was: " + rNum);
            System.out.print("Do you want to play again? (yes/no): ");
        } while (s.next().equalsIgnoreCase("yes"));
        System.out.println("\nGame Over! You played " + rt +
                " rounds. Your total score is " + rt + " attempts.");
        s.close();
    }
}
