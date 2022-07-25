import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;

        List<Integer> lst = arr.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < lst.size() - 1; i++) {
            min = Math.min(min, Math.abs(lst.get(i) - lst.get(i + 1)));
        }

        return min;
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

            int result = Result.minimumAbsoluteDifference(arr);

            System.out.println(String.valueOf(result));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
