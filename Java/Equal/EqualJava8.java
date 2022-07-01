import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultJava8 {
    /*
     * Complete the 'equal' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long equal(List<Integer> arr) {
        // Write your code here

        int[] cookies = arr.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(cookies);

        long sum = Long.MAX_VALUE;

        for (int base = 0; base < 3; base++) {
            int current_sum = 0;
            for (int i = 0; i < cookies.length; i++) {
                int delta = cookies[i] - cookies[0] + base;
                current_sum += (int) delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
            }
            sum = Math.min(current_sum, sum);
        }

        return sum;
    }
}

public class EqualJava8 {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream("stdin.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = ResultJava8.equal(arr);

                System.out.println(result);
                // bufferedWriter.write(String.valueOf(result));
                // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
