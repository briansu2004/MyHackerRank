import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        int bal = 0;

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < contests.size(); i++) {
            bal += contests.get(i).get(0);
            if (contests.get(i).get(1) == 1) {
                lst.add(contests.get(i).get(0));
            }
        }

        Collections.sort(lst);
        int n = lst.size() - k;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                bal -= lst.get(i) * 2;
            }
        }

        return bal;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> contests = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    contests.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.luckBalance(k, contests);

            System.out.println(result);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
