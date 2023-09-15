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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static int[] countSortString(String s) {
        int[] cs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - 'a']++;
        }

        return cs;
    }

    public static String gameOfThrones(String s) {
        // Write your code here
        int[] a = countSortString(s);
        int[] cs = Arrays.stream(a).filter(x -> x > 0).toArray();
        long l = s.length();
        long csl = cs.length;
        long n = Arrays.stream(cs).filter(x -> x % 2 == 0).count();

        if (l % 2 == 0) {
            // Even
            if (csl == n) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            // ODD
            if (n == csl - 1) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("stdin.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String s = bufferedReader.readLine();

            String result = Result.gameOfThrones(s);

            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
