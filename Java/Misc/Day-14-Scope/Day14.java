import java.util.*;

class Difference {
    int[] __elements;

    Difference(int[] nums) {
        __elements = nums;
    }

    int computeDifference() {
        int min = __elements[0];
        int max = __elements[0];

        for (int i = 1; i < __elements.length; i++) {
            min = Math.min(min, __elements[i]);
            max = Math.max(max, __elements[i]);
        }

        return max - min;
    }
}

public class Day14 {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int[] nums = Arrays.stream(scanner.nextLine().trim().split(" ")).filter(x -> !x.equals(""))
                .mapToInt(Integer::parseInt).toArray();
        scanner.close();

        Difference diff = new Difference(nums);
        int maxDiff = diff.computeDifference();
        System.out.println(maxDiff);
    }
}