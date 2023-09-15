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
     * Complete the 'stringConstruction' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static long stringConstruction(String s) {
        // Write your code here
        return s.chars().distinct().count();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();

                    long result = Result.stringConstruction(s);

                    System.out.println(String.valueOf(result));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
