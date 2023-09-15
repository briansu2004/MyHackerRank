import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'beautifulPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY A
     * 2. INTEGER_ARRAY B
     */

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
        int a = A.size();
        int b = B.size();
        if (a > b) {
            A.retainAll(B);
            // return A.stream().distinct().collect(Collectors.toList()).size() + 1;
            return A.size() + 1;
        }

        B.retainAll(A);
        // return B.stream().distinct().collect(Collectors.toList()).size() + 1;
        return B.size() + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.beautifulPairs(A, B);
            System.out.println(String.valueOf(result));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
