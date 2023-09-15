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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
        List<Integer> lst = new ArrayList<>();

        Collections.sort(sticks, Collections.reverseOrder());

        for (int i = 0; i < sticks.size() - 2; i++) {
            int a = sticks.get(i);
            int b = sticks.get(i + 1);
            int c = sticks.get(i + 2);
            if (a < b + c) {
                lst.add(a);
                return Arrays.asList(c, b, a);
            }
        }

        return Arrays.asList(-1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.maximumPerimeterTriangle(sticks);

            System.out.println(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
