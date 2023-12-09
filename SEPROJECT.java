import java.util.Scanner;

public class SEPROJECT {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] weights = {0.15, 0.05, 0.25, 0.3, 0.25};
        String[] categories = {"Homework", "Quiz", "Midterm Exam", "Final Exam", "Final Project"};

        double totalScore = calculateTotalScore(weights, categories);

        char letterGrade = determineLetterGrade(totalScore);

        System.out.println("Total Grade: " + totalScore);
        System.out.println("Letter Grade: " + letterGrade);

        input.close();
    }

    private static double calculateTotalScore(double[] weights, String[] categories) {
        double total = 0;

        for (int i = 0; i < weights.length; i++) {
            total += getAverageScore(categories[i], getNumberOfAssignments(categories[i])) * weights[i];
        }

        return total;
    }

    private static int getNumberOfAssignments(String category) {
        if (category.equals("Homework")) {
            return 8;
        } else if (category.equals("Quiz")) {
            return 5;
        } else {
            return 1;
        }
    }

    private static double getAverageScore(String category, int count) {
        double total = 0;

        for (int i = 1; i <= count; i++) {
            total += getScore(category + " " + i);
        }

        return total / count;
    }

    private static double getScore(String category) {
        Scanner scanner = new Scanner(System.in);
        double score;

        do {
            System.out.print("Enter " + category + " score (out of 100): ");
            score = scanner.nextDouble();

            if (score < 0 || score > 100) {
                System.out.println("Invalid input. Score must be between 0 and 100. Please try again.");
            }

        } while (score < 0 || score > 100);

        return score;
    }

    private static char determineLetterGrade(double totalScore) {
        if (totalScore >= 90) {
            return 'A';
        } else if (totalScore >= 80) {
            return 'B';
        } else if (totalScore >= 70) {
            return 'C';
        } else if (totalScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
