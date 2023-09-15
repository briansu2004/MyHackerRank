import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY arr
     * 2. INTEGER_ARRAY brr
     */

    public static int[] countSort(List<Integer> arr, int min, int max) {
        int[] cs = new int[max - min + 1];

        for (int i = 0; i < arr.size(); i++) {
            cs[arr.get(i) - min]++;
        }

        return cs;
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> lst = new ArrayList<>();

        int min = Collections.min(brr);
        int max = Collections.max(brr);
        int[] csa = countSort(arr, min, max);
        int[] csb = countSort(brr, min, max);
        for (int i = 0; i < max - min + 1; i++) {
            if (csa[i] != csb[i]) {
                lst.add(i + min);
            }
        }

        return lst;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int m = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.missingNumbers(arr, brr);

            System.out.println(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
