import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    public int solve(ArrayList<Integer> A) {
        return (int) inversionCount(A, 0, A.size() - 1);
    }

    final static long M = 1000000007;

    /***
     * Copies the elements from start to end (inclusive) to another ArrayList
     ***/
    public static ArrayList<Integer> copy(ArrayList<Integer> a, int start, int end) {
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = start; i <= end; i++)
            copy.add(a.get(i));
        return copy;
    }

    public static long mergeCount(ArrayList<Integer> a, int start, int mid, int end) {
        // Split the arraylist into 2 halves

        ArrayList<Integer> first = copy(a, start, mid);
        ArrayList<Integer> second = copy(a, mid + 1, end);

        int i = 0; // pointer for first
        int j = 0; // pointer for second
        int k = start; // pointer to store the merged elements

        int l1 = first.size();
        int l2 = second.size();

        long count = 0; // inversion count due to merging the 2 halves

        while (i < l1 && j < l2) {
            int x = first.get(i), y = second.get(j);
            if (x <= y) {
                // Element from first half is smaller
                // So it doesn't contribute to the Inversion Count

                a.set(k++, x);
                i++;
            } else {
                // Element from second half is smaller
                // So it contributes to the Inversion Count
                // Contribution : l1 - i

                a.set(k++, y);
                j++;
                count = (count + l1 - i) % M;
            }
        }

        // Merge remaining elements

        while (i < l1)
            a.set(k++, first.get(i++));
        while (j < l2)
            a.set(k++, second.get(j++));

        return count;
    }

    public static long inversionCount(ArrayList<Integer> a, int start, int end) {
        // BASE CASE : Only 1 element is there
        if (start == end)
            return 0;

        int m = (start + end) / 2;

        // IC = IC(left) + IC(right) + C
        // C : due to merging

        return ((inversionCount(a, start, m) + inversionCount(a, m + 1, end)) % M
                + mergeCount(a, start, m, end)) % M;
    }

    /*
     * Complete the 'insertionSort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long insertionSort(ArrayList<Integer> arr) {
        // Write your code here
        return inversionCount(arr, 0, arr.size() - 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("stdin.txt"));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter("stdout.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                ArrayList<Integer> arr = new ArrayList<Integer>(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));

                long result = Result.insertionSort(arr);

                // bufferedWriter.write(String.valueOf(result));
                // bufferedWriter.newLine();
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
