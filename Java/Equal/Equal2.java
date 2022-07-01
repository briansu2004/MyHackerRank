import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result2 {
    /*
     * Complete the 'equal' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    /*
     * 1. substract from 1 === adding to all but 1
     * 2. min and min - 4 (because 5 - 1 = 4)
     * 3. 1,2,5 => t / 5 + t % 5 / 2 + t % 5 % 2
     */
    public static long equal(List<Integer> arr) {
        // Write your code here
        int[] a = arr.stream().mapToInt(Integer::intValue).toArray();
        int min = Arrays.stream(a).min().getAsInt();
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 5; ++i) {
            int ops = 0;
            for (int j = 0; j < a.length; ++j) {
                int t = a[j] - (min - i);
                ops += t / 5 + t % 5 / 2 + t % 5 % 2;
            }
            ans = Math.min(ans, ops);
        }
        return ans;
    }
}

public class Equal2 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("stdin.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = Result2.equal(arr);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
