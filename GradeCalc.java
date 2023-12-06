//Task 2 Grade Calculator
import java.util.Scanner;
public class GradeCalc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int n = s.nextInt(), t = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int m = s.nextInt();
            if (m < 0 || m > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                i--;
                continue;
            }
            t += m;
        }
        double avg = (double) t / n;
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + t + " out of " + (n * 100));
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + calculateGrade(avg));
        s.close();
    }
    private static char calculateGrade(double avg) {
        if (avg>=90) return 'A';
        else if (avg>=80) return 'B';
        else if (avg>=70) return 'C';
        else if (avg>=60) return 'D';
        else if (avg>=50) return 'E';
        else if (avg>=40) return 'P';
        else return 'F';
    }
}
