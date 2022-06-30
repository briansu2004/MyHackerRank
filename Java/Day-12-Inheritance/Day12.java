import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Heraldo Memelli 8135627
2
100 80
 */
class Day12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        String lastName = scanner.next();
        int id = scanner.nextInt();
        int numScores = scanner.nextInt();
        Queue<Integer> scores = new LinkedList<>();
        for (int i = 0; i < numScores; i++) {
            scores.add(scanner.nextInt());
        }
        scanner.close();

        double averageScore = scores.stream().mapToInt(Integer::intValue).sum() / numScores;
        char grade;
        if (averageScore >= 90) {
            grade = 'O';
        } else if (averageScore >= 80) {
            grade = 'E';
        } else if (averageScore >= 70) {
            grade = 'A';
        } else if (averageScore >= 55) {
            grade = 'P';
        } else if (averageScore >= 40) {
            grade = 'D';
        } else {
            grade = 'T';
        }

        System.out.printf("Name: %s, %s%n", lastName, firstName);
        System.out.printf("ID: %s%n", id);
        System.out.printf("Grade: %s", grade);
    }
}