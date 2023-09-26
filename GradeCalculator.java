import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables
        int totalMarks = 0;
        double averagePercentage;
        
        System.out.println("Enter marks obtained (out of 100) for each subject:");

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();

            // Ensure marks are within the valid range
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        averagePercentage = (double) totalMarks / numSubjects;

        // Assign grades based on the average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\nHere is your Results");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Thank you for using this program to claculate your grade.");

        scanner.close();
    }
}
