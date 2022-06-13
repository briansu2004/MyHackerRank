import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'longestIncreasingSubsequence' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestIncreasingSubsequence(int[] nums) {
        // Write your code here
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[res - 1]) {
                dp[res] = nums[i];
                res++;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] >= nums[i]) {
                        dp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return res;
    }

}

public class lis {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("stdin.txt"));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
        // try {
        // return bufferedReader.readLine().replaceAll("\\s+$", "");
        // } catch (IOException ex) {
        // throw new RuntimeException(ex);
        // }
        // })
        // .map(String::trim)
        // .map(Integer::parseInt)
        // .collect(toList());

        int[] arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList())
                .stream().mapToInt(Integer::intValue).toArray();

        int result = Result.longestIncreasingSubsequence(arr);

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
