import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER k
     * 3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> ar, int k, List<Integer> queries) {
        // Write your code here
        int[] a = ar.stream().mapToInt(Integer::intValue).toArray();
        int[] q = queries.stream().mapToInt(Integer::intValue).toArray();

        int arr[] = new int[a.length];

        for (int i = 0; i < a.length; i++)
            arr[(i + k) % a.length] = a[i];

        for (int i = 0; i < q.length; i++)
            q[i] = arr[q[i]];

        return Arrays.stream(q).boxed().collect(Collectors.toList());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            int q = Integer.parseInt(firstMultipleInput[2]);

            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.circularArrayRotation(a, k, queries);

            System.out.println(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
