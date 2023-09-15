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
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER m
     * 2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> lst = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            int y = m - x;
            Integer j = map.get(y);
            if (j != null) {
                lst.add(j + 1);
                lst.add(i + 1);
                return lst;
            }
            map.put(x, i);
        }

        return lst;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int m = Integer.parseInt(bufferedReader.readLine().trim());

                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    List<Integer> result = Result.icecreamParlor(m, arr);

                    System.out.println(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(joining(" ")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
