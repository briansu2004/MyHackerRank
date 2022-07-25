import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    private Result() {
        throw new IllegalStateException("Result class");
      }
    /*
     * Complete the 'marcsCakewalk' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY calorie as parameter.
     */

    public static long marcsCakewalk(List<Integer> calorie) {
        // Write your code here
        Long sum = 0L;

        List<Integer> lst = calorie.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < lst.size(); i++) {
            sum += (long) (lst.get(i) * Math.pow(2, i));
        }

        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> calorie = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            long result = Result.marcsCakewalk(calorie);

            System.out.println(String.valueOf(result));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
